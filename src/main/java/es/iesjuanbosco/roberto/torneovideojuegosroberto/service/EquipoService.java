package es.iesjuanbosco.roberto.torneovideojuegosroberto.service;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.EquipoRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.EquipoResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.JugadorSimpleDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Equipo;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Inscripcion;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.enums.EstadoInscripcion;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.exception.ResourceNotFoundException;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.mapper.EquipoMapper;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.mapper.JugadorMapper;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.repository.EquipoRepository;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.repository.InscripcionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EquipoService {

    private final EquipoRepository equipoRepository;
    private final EquipoMapper equipoMapper;
    private final InscripcionRepository inscripcionRepository;
    private final JugadorMapper jugadorMapper;

    public Page<EquipoResponseDTO> listar(Pageable pageable) {
        Page<Equipo> equipos = equipoRepository.findAll(pageable);
        return equipos.map(equipo -> {
            EquipoResponseDTO dto = equipoMapper.toResponseDTO(equipo);
            // Calcular cantidad de miembros activos
            Long cantidad = equipoRepository.contarMiembrosActivos(equipo.getId(), EstadoInscripcion.CONFIRMADA);
            dto.setCantidadMiembros(cantidad.intValue());
            return dto;
        });
    }


    public EquipoResponseDTO buscarPorId(Integer id) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado con ID: " + id));

        EquipoResponseDTO dto = equipoMapper.toResponseDTO(equipo);

        // Calcular cantidad de miembros activos
        Long cantidad = equipoRepository.contarMiembrosActivos(id, EstadoInscripcion.CONFIRMADA);
        dto.setCantidadMiembros(cantidad.intValue());

        // Obtener miembros activos
        List<Inscripcion> inscripciones = inscripcionRepository
                .findByEquipoIdAndEstado(id, EstadoInscripcion.CONFIRMADA);
        List<JugadorSimpleDTO> miembros = inscripciones.stream()
                .map(i -> jugadorMapper.toSimpleDTO(i.getJugador()))
                .collect(Collectors.toList());
        dto.setMiembros(miembros);

        return dto;
    }


    @Transactional
    public EquipoResponseDTO crear(EquipoRequestDTO dto) {
        Equipo equipo = equipoMapper.toEntity(dto);
        // Asegurar que fechaCreacion se establezca si no se hizo automáticamente
        if (equipo.getFechaCreacion() == null) {
            equipo.setFechaCreacion(java.time.LocalDateTime.now());
        }
        Equipo guardado = equipoRepository.save(equipo);

        EquipoResponseDTO responseDTO = equipoMapper.toResponseDTO(guardado);
        responseDTO.setCantidadMiembros(0);

        return responseDTO;
    }


    @Transactional
    public EquipoResponseDTO actualizar(Integer id, EquipoRequestDTO dto) {
        Equipo equipo = equipoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado con ID: " + id));

        equipoMapper.updateEntityFromDTO(dto, equipo);
        Equipo actualizado = equipoRepository.save(equipo);

        EquipoResponseDTO responseDTO = equipoMapper.toResponseDTO(actualizado);
        Long cantidad = equipoRepository.contarMiembrosActivos(id, EstadoInscripcion.CONFIRMADA);
        responseDTO.setCantidadMiembros(cantidad.intValue());

        return responseDTO;
    }


    @Transactional
    public void eliminar(Integer id) {
        if (!equipoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Equipo no encontrado con ID: " + id);
        }
        equipoRepository.deleteById(id);
    }
}