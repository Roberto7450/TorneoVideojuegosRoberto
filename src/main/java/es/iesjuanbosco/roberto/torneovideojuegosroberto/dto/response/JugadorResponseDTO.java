package es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Period;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JugadorResponseDTO {

    private Integer id;
    private String nombre;
    private String nickname;
    private String email;
    private LocalDate fechaNacimiento;
    private String pais;

    public Integer getEdad() {
        if (fechaNacimiento != null) {
            return Period.between(fechaNacimiento, LocalDate.now()).getYears();
        }
        return null;
    }
}

