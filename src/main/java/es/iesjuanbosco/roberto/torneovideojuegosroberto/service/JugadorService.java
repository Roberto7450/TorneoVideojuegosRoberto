package es.iesjuanbosco.roberto.torneovideojuegosroberto.service;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.JugadorRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.JugadorResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Jugador;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.exception.ConflictException;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.exception.ResourceNotFoundException;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.mapper.JugadorMapper;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.repository.JugadorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class JugadorService {

    private final JugadorRepository jugadorRepository;
    private final JugadorMapper jugadorMapper;

    public Page<JugadorResponseDTO> listar(Pageable pageable) {
        Page<Jugador> jugadores = jugadorRepository.findAll(pageable);
        return jugadores.map(jugadorMapper::toResponseDTO);
    }


    public JugadorResponseDTO buscarPorId(Integer id) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jugador no encontrado con ID: " + id));
        return jugadorMapper.toResponseDTO(jugador);
    }


    @Transactional
    public JugadorResponseDTO crear(JugadorRequestDTO dto) {
        // RN-01: Verificar que el email no exista
        if (jugadorRepository.existsByEmail(dto.getEmail())) {
            throw new ConflictException("El email ya está registrado");
        }

        // RN-01: Verificar que el nickname no exista
        if (jugadorRepository.existsByNickname(dto.getNickname())) {
            throw new ConflictException("El nickname ya está registrado");
        }

        Jugador jugador = jugadorMapper.toEntity(dto);
        Jugador guardado = jugadorRepository.save(jugador);
        return jugadorMapper.toResponseDTO(guardado);
    }


    @Transactional
    public JugadorResponseDTO actualizar(Integer id, JugadorRequestDTO dto) {
        Jugador jugador = jugadorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jugador no encontrado con ID: " + id));

        // Verificar unicidad solo si cambió el email
        if (!jugador.getEmail().equals(dto.getEmail())
                && jugadorRepository.existsByEmail(dto.getEmail())) {
            throw new ConflictException("El email ya está registrado");
        }

        // Verificar unicidad solo si cambió el nickname
        if (!jugador.getNickname().equals(dto.getNickname())
                && jugadorRepository.existsByNickname(dto.getNickname())) {
            throw new ConflictException("El nickname ya está registrado");
        }

        jugadorMapper.updateEntityFromDTO(dto, jugador);
        Jugador actualizado = jugadorRepository.save(jugador);
        return jugadorMapper.toResponseDTO(actualizado);
    }


    @Transactional
    public void eliminar(Integer id) {
        if (!jugadorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Jugador no encontrado con ID: " + id);
        }
        jugadorRepository.deleteById(id);
    }
}