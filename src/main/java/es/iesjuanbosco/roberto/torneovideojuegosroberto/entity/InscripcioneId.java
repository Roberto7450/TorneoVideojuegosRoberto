package es.iesjuanbosco.roberto.torneovideojuegosroberto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class InscripcioneId implements Serializable {
    private static final long serialVersionUID = -7346314730488534886L;
    @NotNull
    @Column(name = "jugador_id", nullable = false)
    private Integer jugadorId;

    @NotNull
    @Column(name = "torneo_id", nullable = false)
    private Integer torneoId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        InscripcioneId entity = (InscripcioneId) o;
        return Objects.equals(this.jugadorId, entity.jugadorId) &&
                Objects.equals(this.torneoId, entity.torneoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jugadorId, torneoId);
    }

}