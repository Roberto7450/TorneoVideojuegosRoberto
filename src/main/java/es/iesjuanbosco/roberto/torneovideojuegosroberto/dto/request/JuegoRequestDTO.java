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
public class JuegoRequestDTO {

    @NotBlank(message = "El nombre del juego es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "El género es obligatorio")
    @Size(min = 2, max = 100, message = "El género debe tener entre 2 y 100 caracteres")
    private String genero;

    @NotBlank(message = "El desarrollador es obligatorio")
    @Size(min = 2, max = 100, message = "El desarrollador debe tener entre 2 y 100 caracteres")
    private String desarrollador;

    @NotNull(message = "La fecha de salida es obligatoria")
    @PastOrPresent(message = "La fecha de salida no puede ser futura")
    private LocalDate fechaSalida;
}

