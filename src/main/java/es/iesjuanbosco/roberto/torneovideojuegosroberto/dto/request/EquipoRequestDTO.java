package es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipoRequestDTO {

    @NotBlank(message = "El nombre del equipo es obligatorio")
    @Size(min = 3, max = 100, message = "El nombre debe tener entre 3 y 100 caracteres")
    private String nombre;

    @Size(max = 255, message = "La URL del logo no puede exceder 255 caracteres")
    @Pattern(regexp = "^(https?://.*)?$", message = "La URL del logo debe ser válida")
    private String logoUrl;
}

