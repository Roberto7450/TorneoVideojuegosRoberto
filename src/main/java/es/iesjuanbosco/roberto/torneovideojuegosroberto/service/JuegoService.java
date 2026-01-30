package es.iesjuanbosco.roberto.torneovideojuegosroberto.service;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.JuegoRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.JuegoResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Juego;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.exception.ResourceNotFoundException;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.mapper.JuegoMapper;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.repository.JuegoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JuegoService {

    private final JuegoRepository juegoRepository;
    private final JuegoMapper juegoMapper;

    public Page<JuegoResponseDTO> listar(Pageable pageable) {
        Page<Juego> juegos = juegoRepository.findAll(pageable);
        return juegos.map(juego -> {
            JuegoResponseDTO dto = juegoMapper.toResponseDTO(juego);
            // Calcular cantidad de torneos
            dto.setCantidadTorneos(juego.getTorneos() != null ? juego.getTorneos().size() : 0);
            return dto;
        });
    }


    public JuegoResponseDTO buscarPorId(Integer id) {
        Juego juego = juegoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Juego no encontrado con ID: " + id));

        JuegoResponseDTO dto = juegoMapper.toResponseDTO(juego);
        dto.setCantidadTorneos(juego.getTorneos() != null ? juego.getTorneos().size() : 0);

        return dto;
    }


    @Transactional
    public JuegoResponseDTO crear(JuegoRequestDTO dto) {
        Juego juego = juegoMapper.toEntity(dto);
        Juego guardado = juegoRepository.save(juego);

        JuegoResponseDTO responseDTO = juegoMapper.toResponseDTO(guardado);
        responseDTO.setCantidadTorneos(0);

        return responseDTO;
    }


    @Transactional
    public JuegoResponseDTO actualizar(Integer id, JuegoRequestDTO dto) {
        Juego juego = juegoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Juego no encontrado con ID: " + id));

        juegoMapper.updateEntityFromDTO(dto, juego);
        Juego actualizado = juegoRepository.save(juego);

        JuegoResponseDTO responseDTO = juegoMapper.toResponseDTO(actualizado);
        responseDTO.setCantidadTorneos(actualizado.getTorneos() != null ? actualizado.getTorneos().size() : 0);

        return responseDTO;
    }


    @Transactional
    public void eliminar(Integer id) {
        if (!juegoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Juego no encontrado con ID: " + id);
        }
        juegoRepository.deleteById(id);
    }
}