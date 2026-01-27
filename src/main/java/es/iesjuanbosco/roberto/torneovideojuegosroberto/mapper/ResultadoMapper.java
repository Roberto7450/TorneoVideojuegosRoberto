package es.iesjuanbosco.roberto.torneovideojuegosroberto.mapper;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.ResultadoRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.ResultadoResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Resultado;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ResultadoMapper {

    @Mapping(source = "equipo.id", target = "equipoId")
    @Mapping(source = "equipo.nombre", target = "equipoNombre")
    @Mapping(source = "equipo.logoUrl", target = "equipoLogo")
    @Mapping(source = "torneo.id", target = "torneoId")
    @Mapping(source = "torneo.nombre", target = "torneoNombre")
    ResultadoResponseDTO toResponseDTO(Resultado resultado);

    List<ResultadoResponseDTO> toResponseDTOList(List<Resultado> resultados);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "equipo", ignore = true)
    @Mapping(target = "torneo", ignore = true)
    Resultado toEntity(ResultadoRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "equipo", ignore = true)
    @Mapping(target = "torneo", ignore = true)
    void updateEntityFromDTO(ResultadoRequestDTO dto, @MappingTarget Resultado resultado);
}