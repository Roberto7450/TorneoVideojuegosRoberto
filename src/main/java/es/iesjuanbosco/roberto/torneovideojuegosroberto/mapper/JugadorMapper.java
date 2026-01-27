package es.iesjuanbosco.roberto.torneovideojuegosroberto.mapper;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.JugadorRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.JugadorResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.JugadorSimpleDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Jugador;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JugadorMapper {

    JugadorResponseDTO toResponseDTO(Jugador jugador);

    JugadorSimpleDTO toSimpleDTO(Jugador jugador);

    List<JugadorResponseDTO> toResponseDTOList(List<Jugador> jugadores);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "inscripciones", ignore = true)
    Jugador toEntity(JugadorRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "inscripciones", ignore = true)
    void updateEntityFromDTO(JugadorRequestDTO dto, @MappingTarget Jugador jugador);
}