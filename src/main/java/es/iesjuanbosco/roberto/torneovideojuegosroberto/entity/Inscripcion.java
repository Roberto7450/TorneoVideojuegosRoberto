package es.iesjuanbosco.roberto.torneovideojuegosroberto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.enums.EstadoInscripcion;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "inscripciones")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"jugador", "torneo", "equipo"})
public class Inscripcion {
    @EmbeddedId
    private InscripcioneId id;

    @MapsId("jugadorId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "jugador_id", nullable = false)
    private Jugador jugador;

    @MapsId("torneoId")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "torneo_id", nullable = false)
    private Torneo torneo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")
    private Equipo equipo;

    @NotNull
    @CreationTimestamp
    @Column(name = "fecha_inscripcion", nullable = false, updatable = false)
    private LocalDateTime fechaInscripcion;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "estado", length = 20, nullable = false)
    private EstadoInscripcion estado = EstadoInscripcion.CONFIRMADA;
}