package es.iesjuanbosco.roberto.torneovideojuegosroberto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "torneos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"resultados", "inscripciones", "juego"})
public class Torneo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "torneo_id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull(message = "El nombre del torneo es obligatorio")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 500)
    @Column(name = "descripcion", length = 500)
    private String descripcion;

    @NotNull(message = "La fecha de inicio es obligatoria")
    @Column(name = "fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @NotNull(message = "La fecha final es obligatoria")
    @Column(name = "fecha_final", nullable = false)
    private LocalDate fechaFinal;

    @NotNull
    @Min(value = 1, message = "Debe haber al menos 1 miembro por equipo")
    @Column(name = "miembros_por_equipo", nullable = false)
    private Integer miembrosPorEquipo;

    @NotNull
    @Min(value = 2, message = "Debe haber al menos 2 equipos")
    @Column(name = "max_equipos", nullable = false)
    private Integer maxEquipos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "juego_id")
    private Juego juego;

    @OneToMany(mappedBy = "torneo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resultado> resultados = new ArrayList<>();

    @OneToMany(mappedBy = "torneo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscripcion> inscripciones = new ArrayList<>();
}