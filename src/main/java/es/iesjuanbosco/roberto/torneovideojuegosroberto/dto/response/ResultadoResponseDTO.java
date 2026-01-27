package es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResultadoResponseDTO {

    private Integer equipoId;
    private String equipoNombre;
    private String equipoLogo;
    private Integer torneoId;
    private String torneoNombre;
    private Integer posicion;
    private Integer puntuacion;
}

