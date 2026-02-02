package es.iesjuanbosco.roberto.torneovideojuegosroberto.service;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.TorneoRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.TorneoResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Juego;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Torneo;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.enums.EstadoInscripcion;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.exception.ResourceNotFoundException;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.exception.ValidationException;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.mapper.TorneoMapper;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.repository.JuegoRepository;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.repository.TorneoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TorneoService {

    private final TorneoRepository torneoRepository;
    private final JuegoRepository juegoRepository;
    private final TorneoMapper torneoMapper;

    public Page<TorneoResponseDTO> listar(Pageable pageable) {
        Page<Torneo> torneos = torneoRepository.findAll(pageable);
        return torneos.map(this::convertirADTO);
    }


    public TorneoResponseDTO buscarPorId(Integer id) {
        Torneo torneo = torneoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Torneo no encontrado con ID: " + id));
        return convertirADTO(torneo);
    }


    @Transactional
    public TorneoResponseDTO crear(TorneoRequestDTO dto) {
        // RN-05: Verificar que fechaInicio < fechaFinal
        if (!dto.getFechaInicio().isBefore(dto.getFechaFinal())) {
            throw new ValidationException("La fecha de inicio debe ser anterior a la fecha final");
        }

        // Buscar el juego
        Juego juego = juegoRepository.findById(dto.getJuegoId())
                .orElseThrow(() -> new ResourceNotFoundException("Juego no encontrado con ID: " + dto.getJuegoId()));

        Torneo torneo = torneoMapper.toEntity(dto);
        torneo.setJuego(juego);

        Torneo guardado = torneoRepository.save(torneo);
        return convertirADTO(guardado);
    }


    @Transactional
    public TorneoResponseDTO actualizar(Integer id, TorneoRequestDTO dto) {
        Torneo torneo = torneoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Torneo no encontrado con ID: " + id));

        // RN-05: Verificar fechas
        if (!dto.getFechaInicio().isBefore(dto.getFechaFinal())) {
            throw new ValidationException("La fecha de inicio debe ser anterior a la fecha final");
        }

        // Actualizar juego si cambió
        if (!torneo.getJuego().getId().equals(dto.getJuegoId())) {
            Juego juego = juegoRepository.findById(dto.getJuegoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Juego no encontrado con ID: " + dto.getJuegoId()));
            torneo.setJuego(juego);
        }

        torneoMapper.updateEntityFromDTO(dto, torneo);
        Torneo actualizado = torneoRepository.save(torneo);

        return convertirADTO(actualizado);
    }


    @Transactional
    public void eliminar(Integer id) {
        if (!torneoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Torneo no encontrado con ID: " + id);
        }
        torneoRepository.deleteById(id);
    }


    private TorneoResponseDTO convertirADTO(Torneo torneo) {
        TorneoResponseDTO dto = torneoMapper.toResponseDTO(torneo);

        // Calcular equipos inscritos y cupos disponibles
        Long inscritos = torneoRepository.contarEquiposInscritos(torneo.getId(), EstadoInscripcion.CONFIRMADA);
        dto.setEquiposInscritos(inscritos.intValue());
        dto.setCuposDisponibles(torneo.getMaxEquipos() - inscritos.intValue());

        return dto;
    }
}