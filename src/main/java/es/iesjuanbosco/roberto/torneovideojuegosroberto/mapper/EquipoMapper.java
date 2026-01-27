package es.iesjuanbosco.roberto.torneovideojuegosroberto.mapper;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.EquipoRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.EquipoResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Equipo;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EquipoMapper {

    @Mapping(target = "miembros", ignore = true) // Se calcula en Service
    @Mapping(target = "cantidadMiembros", ignore = true) // Se calcula en Service
    EquipoResponseDTO toResponseDTO(Equipo equipo);

    List<EquipoResponseDTO> toResponseDTOList(List<Equipo> equipos);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "resultados", ignore = true)
    @Mapping(target = "inscripciones", ignore = true)
    Equipo toEntity(EquipoRequestDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaCreacion", ignore = true)
    @Mapping(target = "resultados", ignore = true)
    @Mapping(target = "inscripciones", ignore = true)
    void updateEntityFromDTO(EquipoRequestDTO dto, @MappingTarget Equipo equipo);
}