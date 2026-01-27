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
public class TorneoResponseDTO {

    private Integer id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private Integer maxEquipos;
    private Integer miembrosPorEquipo;
    private Integer equiposInscritos;
    private Integer cuposDisponibles;
    private JuegoSimpleDTO juego;
}

