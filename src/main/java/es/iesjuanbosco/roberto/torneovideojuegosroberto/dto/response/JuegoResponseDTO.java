package es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JuegoResponseDTO {

    private Integer id;
    private String nombre;
    private String genero;
    private String desarrollador;
    private LocalDate fechaSalida;
    private Integer cantidadTorneos;
}

