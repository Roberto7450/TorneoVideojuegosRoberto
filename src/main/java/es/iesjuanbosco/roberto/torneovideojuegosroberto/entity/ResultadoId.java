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
public class ResultadoId implements Serializable {
    private static final long serialVersionUID = -5827076282681860851L;
    @NotNull
    @Column(name = "equipo_id", nullable = false)
    private Integer equipoId;

    @NotNull
    @Column(name = "torneo_id", nullable = false)
    private Integer torneoId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ResultadoId entity = (ResultadoId) o;
        return Objects.equals(this.equipoId, entity.equipoId) &&
                Objects.equals(this.torneoId, entity.torneoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(equipoId, torneoId);
    }

}