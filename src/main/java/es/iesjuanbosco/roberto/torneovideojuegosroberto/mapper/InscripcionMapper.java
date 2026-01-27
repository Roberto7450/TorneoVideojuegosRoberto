package es.iesjuanbosco.roberto.torneovideojuegosroberto.mapper;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.InscripcionRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.InscripcionResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Inscripcion;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InscripcionMapper {

    @Mapping(source = "jugador.id", target = "jugadorId")
    @Mapping(source = "jugador.nickname", target = "jugadorNickname")
    @Mapping(source = "torneo.id", target = "torneoId")
    @Mapping(source = "torneo.nombre", target = "torneoNombre")
    @Mapping(source = "equipo.id", target = "equipoId")
    @Mapping(source = "equipo.nombre", target = "equipoNombre")
    InscripcionResponseDTO toResponseDTO(Inscripcion inscripcion);

    List<InscripcionResponseDTO> toResponseDTOList(List<Inscripcion> inscripciones);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "jugador", ignore = true)
    @Mapping(target = "torneo", ignore = true)
    @Mapping(target = "equipo", ignore = true)
    @Mapping(target = "fechaInscripcion", ignore = true)
    @Mapping(target = "estado", ignore = true)
    Inscripcion toEntity(InscripcionRequestDTO dto);
}