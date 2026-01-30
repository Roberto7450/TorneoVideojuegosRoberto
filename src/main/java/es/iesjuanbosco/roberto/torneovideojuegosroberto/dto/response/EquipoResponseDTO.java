package es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EquipoResponseDTO {

    private Integer id;
    private String nombre;
    private String logoUrl;
    private LocalDate fechaCreacion;
    private Integer cantidadMiembros;
    private List<JugadorSimpleDTO> miembros;
}

