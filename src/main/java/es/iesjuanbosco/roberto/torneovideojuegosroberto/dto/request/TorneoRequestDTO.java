package es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TorneoRequestDTO {

    @NotBlank(message = "El nombre del torneo es obligatorio")
    @Size(min = 5, max = 100, message = "El nombre debe tener entre 5 y 100 caracteres")
    private String nombre;

    @Size(max = 500, message = "La descripción no puede exceder los 500 caracteres")
    private String descripcion;

    @NotNull(message = "La fecha de inicio es obligatoria")
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha de finalización es obligatoria")
    private LocalDate fechaFinal;

    @NotNull(message = "El máximo de equipos es obligatorio")
    @Min(value = 2, message = "Debe haber al menos 2 equipos")
    @Max(value = 128, message = "No se permiten más de 128 equipos")
    private Integer maxEquipos;

    @NotNull(message = "La cantidad de miembros por equipo es obligatoria")
    @Min(value = 1, message = "Debe haber al menos 1 miembro por equipo")
    @Max(value = 10, message = "No se permiten más de 10 miembros por equipo")
    private Integer miembrosPorEquipo;

    @NotNull(message = "El ID del juego es obligatorio")
    private Integer juegoId;
}

