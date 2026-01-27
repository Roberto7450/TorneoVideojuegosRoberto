package es.iesjuanbosco.roberto.torneovideojuegosroberto.mapper;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.JuegoRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.JuegoResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.JuegoSimpleDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Juego;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface JuegoMapper {

    @Mapping(target = "cantidadTorneos", ignore = true) // Se calcula en Service
    JuegoResponseDTO toResponseDTO(Juego juego);

    JuegoSimpleDTO toSimpleDTO(Juego juego);

    List<JuegoResponseDTO> toResponseDTOList(List<Juego> juegos);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "torneos", ignore = true)
    Juego toEntity(JuegoRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "torneos", ignore = true)
    void updateEntityFromDTO(JuegoRequestDTO dto, @MappingTarget Juego juego);
}