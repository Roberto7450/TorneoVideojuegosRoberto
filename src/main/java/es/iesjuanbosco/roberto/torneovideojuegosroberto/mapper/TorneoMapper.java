package es.iesjuanbosco.roberto.torneovideojuegosroberto.mapper;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.TorneoRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.JuegoSimpleDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.TorneoResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Juego;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Torneo;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TorneoMapper {

    @Mapping(target = "equiposInscritos", ignore = true) // Se calcula en Service
    @Mapping(target = "cuposDisponibles", ignore = true) // Se calcula en Service
    TorneoResponseDTO toResponseDTO(Torneo torneo);

    List<TorneoResponseDTO> toResponseDTOList(List<Torneo> torneos);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "juego", ignore = true) // Se asigna en Service
    @Mapping(target = "resultados", ignore = true)
    @Mapping(target = "inscripciones", ignore = true)
    Torneo toEntity(TorneoRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "juego", ignore = true)
    @Mapping(target = "resultados", ignore = true)
    @Mapping(target = "inscripciones", ignore = true)
    void updateEntityFromDTO(TorneoRequestDTO dto, @MappingTarget Torneo torneo);

    // Método auxiliar para convertir Juego a JuegoSimpleDTO
    JuegoSimpleDTO juegoToSimpleDTO(Juego juego);
}