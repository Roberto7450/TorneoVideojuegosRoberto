package es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultadoRequestDTO {

    @NotNull(message = "El ID del equipo es obligatorio")
    private Integer equipoId;

    @NotNull(message = "El ID del torneo es obligatorio")
    private Integer torneoId;

    @NotNull(message = "La puntuación es obligatoria")
    @Min(value = 0, message = "La puntuación no puede ser negativa")
    private Integer puntuacion;
}

