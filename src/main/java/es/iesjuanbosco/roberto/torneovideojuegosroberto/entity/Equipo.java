package es.iesjuanbosco.roberto.torneovideojuegosroberto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "equipos")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"resultados", "inscripciones"})
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "equipo_id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull(message = "El nombre del equipo es obligatorio")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 255)
    @Column(name = "logo_url")
    private String logoUrl;

    @CreationTimestamp
    @Column(name = "fecha_creacion", nullable = false, updatable = false)
    private LocalDateTime fechaCreacion;

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resultado> resultados = new ArrayList<>();

    @OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscripcion> inscripciones = new ArrayList<>();
}