package es.iesjuanbosco.roberto.torneovideojuegosroberto.service;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.InscripcionRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.InscripcionResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.*;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.enums.EstadoInscripcion;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.exception.ConflictException;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.exception.ResourceNotFoundException;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.exception.ValidationException;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.mapper.InscripcionMapper;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;
    private final JugadorRepository jugadorRepository;
    private final TorneoRepository torneoRepository;
    private final EquipoRepository equipoRepository;
    private final InscripcionMapper inscripcionMapper;

    public Page<InscripcionResponseDTO> listarPorTorneo(Integer torneoId, Pageable pageable) {
        Page<Inscripcion> inscripciones = inscripcionRepository.findByTorneoId(torneoId, pageable);
        return inscripciones.map(inscripcionMapper::toResponseDTO);
    }

    @Transactional
    public InscripcionResponseDTO crear(InscripcionRequestDTO dto) {
        // RN-04: Verificar que el jugador NO esté ya inscrito
        if (inscripcionRepository.existsByJugadorIdAndTorneoId(dto.getJugadorId(), dto.getTorneoId())) {
            throw new ConflictException("El jugador ya está inscrito en este torneo");
        }

        // Buscar entidades
        Jugador jugador = jugadorRepository.findById(dto.getJugadorId())
                .orElseThrow(() -> new ResourceNotFoundException("Jugador no encontrado"));

        Torneo torneo = torneoRepository.findById(dto.getTorneoId())
                .orElseThrow(() -> new ResourceNotFoundException("Torneo no encontrado"));

        Equipo equipo = null;
        boolean esEquipoNuevo = false;

        if (dto.getEquipoId() != null) {
            // CASO 1: Torneo en equipo - el equipo ya existe
            equipo = equipoRepository.findById(dto.getEquipoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado"));

            // RN-02: Verificar que el equipo NO supere el límite de miembros
            // Se permite agregar jugadores hasta alcanzar el máximo (pero no superarlo)
            Long miembrosActivos = equipoRepository.contarMiembrosActivos(equipo.getId(), EstadoInscripcion.CONFIRMADA);
            if (miembrosActivos >= torneo.getMiembrosPorEquipo().longValue()) {
                throw new ValidationException(
                        "El equipo ya tiene el máximo de " + torneo.getMiembrosPorEquipo() + " miembros activos"
                );
            }

            // Verificar si es la primera inscripción de este equipo en el torneo
            // (para contar correctamente los equipos inscritos)
            esEquipoNuevo = !inscripcionRepository.existsByEquipoIdAndTorneoId(equipo.getId(), torneo.getId());

        } else if (torneo.getMiembrosPorEquipo() == 1) {
            // CASO 2: Torneo individual - crear equipo automáticamente
            Equipo equipoIndividual = new Equipo();
            equipoIndividual.setNombre(jugador.getNickname());
            // fechaCreacion se establece automáticamente con @CreationTimestamp
            equipo = equipoRepository.save(equipoIndividual);
            esEquipoNuevo = true;

        } else {
            // CASO 3: Torneo en equipo pero sin equipoId - error
            throw new ValidationException(
                    "El ID del equipo es obligatorio para torneos de " + torneo.getMiembrosPorEquipo() + " miembros"
            );
        }

        // RN-03: Verificar que el torneo NO esté lleno
        // Solo contar si es un equipo nuevo que se está inscribiendo por primera vez
        if (esEquipoNuevo) {
            Long equiposInscritos = torneoRepository.contarEquiposInscritos(torneo.getId(), EstadoInscripcion.CONFIRMADA);
            if (equiposInscritos >= torneo.getMaxEquipos()) {
                throw new ValidationException("El torneo ha alcanzado su capacidad máxima de equipos");
            }
        }

        // Crear inscripción
        InscripcioneId id = new InscripcioneId();
        id.setJugadorId(jugador.getId());
        id.setTorneoId(torneo.getId());

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setId(id);
        inscripcion.setJugador(jugador);
        inscripcion.setTorneo(torneo);
        inscripcion.setEquipo(equipo);
        inscripcion.setEstado(EstadoInscripcion.CONFIRMADA); // RN-06
        // fechaInscripcion se establece automáticamente con @CreationTimestamp

        Inscripcion guardada = inscripcionRepository.saveAndFlush(inscripcion);
        return inscripcionMapper.toResponseDTO(guardada);
    }

    @Transactional
    public InscripcionResponseDTO cambiarEstado(Integer jugadorId, Integer torneoId, EstadoInscripcion nuevoEstado) {
        Inscripcion inscripcion = inscripcionRepository.findByJugadorIdAndTorneoId(jugadorId, torneoId)
                .orElseThrow(() -> new ResourceNotFoundException("Inscripción no encontrada"));

        // RN-06: Solo estados permitidos (enum)
        inscripcion.setEstado(nuevoEstado);

        Inscripcion actualizada = inscripcionRepository.save(inscripcion);
        return inscripcionMapper.toResponseDTO(actualizada);
    }

    @Transactional
    public void eliminar(Integer jugadorId, Integer torneoId) {
        Inscripcion inscripcion = inscripcionRepository.findByJugadorIdAndTorneoId(jugadorId, torneoId)
                .orElseThrow(() -> new ResourceNotFoundException("Inscripción no encontrada"));
        inscripcionRepository.delete(inscripcion);
    }
}