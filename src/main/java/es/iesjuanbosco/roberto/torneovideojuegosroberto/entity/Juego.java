package es.iesjuanbosco.roberto.torneovideojuegosroberto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "juegos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "torneos")
public class Juego {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "juego_id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull(message = "El nombre del juego es obligatorio")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 100)
    @NotNull(message = "El género es obligatorio")
    @Column(name = "genero", nullable = false, length = 100)
    private String genero;

    @Size(max = 100)
    @NotNull(message = "El desarrollador es obligatorio")
    @Column(name = "desarrollador", nullable = false, length = 100)
    private String desarrollador;

    @NotNull(message = "La fecha de salida es obligatoria")
    @PastOrPresent(message = "La fecha no puede ser futura")
    @Column(name = "fecha_salida", nullable = false)
    private LocalDate fechaSalida;

    @OneToMany(mappedBy = "juego", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Torneo> torneos = new ArrayList<>();
}