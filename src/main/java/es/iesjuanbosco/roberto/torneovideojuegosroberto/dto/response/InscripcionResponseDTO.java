package es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.enums.EstadoInscripcion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InscripcionResponseDTO {

    private Integer jugadorId;
    private String jugadorNickname;
    private Integer torneoId;
    private String torneoNombre;
    private Integer equipoId;
    private String equipoNombre;
    private LocalDateTime fechaInscripcion;
    private EstadoInscripcion estado; // CONFIRMADA, ELIMINADA, FINALIZADA
}
