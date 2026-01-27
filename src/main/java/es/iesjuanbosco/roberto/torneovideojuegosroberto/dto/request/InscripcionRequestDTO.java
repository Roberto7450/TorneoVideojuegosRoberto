package es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InscripcionRequestDTO {

    @NotNull(message = "El ID del jugador es obligatorio")
    private Integer jugadorId;

    @NotNull(message = "El ID del torneo es obligatorio")
    private Integer torneoId;

    private Integer equipoId;
}

