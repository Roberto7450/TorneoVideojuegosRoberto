package es.iesjuanbosco.roberto.torneovideojuegosroberto.service;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.ResultadoRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.ResultadoResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.*;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.exception.ResourceNotFoundException;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.exception.ValidationException;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.mapper.ResultadoMapper;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ResultadoService {

    private final ResultadoRepository resultadoRepository;
    private final EquipoRepository equipoRepository;
    private final TorneoRepository torneoRepository;
    private final InscripcionRepository inscripcionRepository;
    private final ResultadoMapper resultadoMapper;

    public List<ResultadoResponseDTO> obtenerRanking(Integer torneoId) {
        List<Resultado> ranking = resultadoRepository.findRankingByTorneoId(torneoId);
        return resultadoMapper.toResponseDTOList(ranking);
    }


    @Transactional
    public ResultadoResponseDTO crear(ResultadoRequestDTO dto) {
        // Buscar entidades
        Equipo equipo = equipoRepository.findById(dto.getEquipoId())
                .orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado"));

        Torneo torneo = torneoRepository.findById(dto.getTorneoId())
                .orElseThrow(() -> new ResourceNotFoundException("Torneo no encontrado"));

        // Validar inscripción
        if (!inscripcionRepository.existsByEquipoIdAndTorneoId(equipo.getId(), torneo.getId())) {
            throw new ValidationException("El equipo no está inscrito en este torneo");
        }

        // Crear resultado
        Resultado resultado = new Resultado();
        ResultadoId id = new ResultadoId();
        id.setEquipoId(equipo.getId());
        id.setTorneoId(torneo.getId());

        resultado.setId(id);
        resultado.setEquipo(equipo);
        resultado.setTorneo(torneo);
        resultado.setPuntuacion(dto.getPuntuacion());

        Resultado guardado = resultadoRepository.save(resultado);
        recalcularPosiciones(torneo.getId());
        return resultadoMapper.toResponseDTO(guardado);
    }


    @Transactional
    public ResultadoResponseDTO actualizar(Integer equipoId, Integer torneoId, ResultadoRequestDTO dto) {
        // Validar inscripción
        if (!inscripcionRepository.existsByEquipoIdAndTorneoId(equipoId, torneoId)) {
            throw new ValidationException("El equipo no está inscrito en este torneo");
        }

        Resultado resultado = resultadoRepository.findByEquipoIdAndTorneoId(equipoId, torneoId)
                .orElseThrow(() -> new ResourceNotFoundException("Resultado no encontrado"));

        resultado.setPuntuacion(dto.getPuntuacion());

        Resultado actualizado = resultadoRepository.save(resultado);
        recalcularPosiciones(torneoId);
        return resultadoMapper.toResponseDTO(actualizado);
    }


    @Transactional
    public void eliminar(Integer equipoId, Integer torneoId) {
        Resultado resultado = resultadoRepository.findByEquipoIdAndTorneoId(equipoId, torneoId)
                .orElseThrow(() -> new ResourceNotFoundException("Resultado no encontrado"));

        resultadoRepository.delete(resultado);
    }


    private void recalcularPosiciones(Integer torneoId) {
        List<Resultado> resultados = resultadoRepository.findRankingByTorneoId(torneoId);

        for (int i = 0; i < resultados.size(); i++) {
            resultados.get(i).setPosicion(i + 1);
        }
        resultadoRepository.saveAll(resultados);
    }
}