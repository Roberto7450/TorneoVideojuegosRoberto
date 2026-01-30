package es.iesjuanbosco.roberto.torneovideojuegosroberto.repository;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Equipo;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.enums.EstadoInscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {

    // RN-02: Contar miembros activos de un equipo
    @Query("SELECT COUNT(DISTINCT i.jugador) FROM Inscripcion i " +
            "WHERE i.equipo.id = :equipoId AND i.estado = :estado")
    Long contarMiembrosActivos(
            @Param("equipoId") Integer equipoId,
            @Param("estado") EstadoInscripcion estado
    );
}
