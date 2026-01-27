package es.iesjuanbosco.roberto.torneovideojuegosroberto.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "jugadores")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = "inscripciones")
public class Jugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "jugador_id", nullable = false)
    private Integer id;

    @Size(max = 100)
    @NotNull(message = "El nombre es obligatorio")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Size(max = 100)
    @NotNull(message = "El nickname es obligatorio")
    @Column(name = "nickname", nullable = false, length = 100, unique = true)
    private String nickname;

    @Size(max = 100)
    @Email(message = "Email debe ser válido")
    @NotNull(message = "El email es obligatorio")
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha debe ser en el pasado")
    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Size(max = 100)
    @NotNull(message = "El país es obligatorio")
    @Column(name = "pais", nullable = false, length = 100)
    private String pais;

    @OneToMany(mappedBy = "jugador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Inscripcion> inscripciones = new ArrayList<>();
}