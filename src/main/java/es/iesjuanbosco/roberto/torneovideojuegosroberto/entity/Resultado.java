package es.iesjuanbosco.roberto.torneovideojuegosroberto.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "resultados")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"equipo", "torneo"})
public class Resultado {
    @EmbeddedId
    private ResultadoId id;

    @MapsId("equipoId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "equipo_id", nullable = false)
    private Equipo equipo;

    @MapsId("torneoId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "torneo_id", nullable = false)
    private Torneo torneo;

    @Column(name = "posicion")
    private Integer posicion;

    @Column(name = "puntuacion", nullable = false)
    private Integer puntuacion = 0;
}