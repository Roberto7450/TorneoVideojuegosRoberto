package es.iesjuanbosco.roberto.torneovideojuegosroberto.repository;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Torneo;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.enums.EstadoInscripcion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneoRepository extends JpaRepository<Torneo, Integer> {

    @Query("SELECT t FROM Torneo t " +
            "WHERE (:nombre IS NULL OR LOWER(t.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))) " +
            "AND (:juegoId IS NULL OR t.juego.id = :juegoId)")
    Page<Torneo> buscarPorNombreYJuego(
            @Param("nombre") String nombre,
            @Param("juegoId") Integer juegoId,
            Pageable pageable
    );

    // RN-03: Contar equipos inscritos (para control de cupos)
    @Query("SELECT COUNT(DISTINCT i.equipo) FROM Inscripcion i " +
            "WHERE i.torneo.id = :torneoId AND i.estado = :estado AND i.equipo IS NOT NULL")
    Long contarEquiposInscritos(
            @Param("torneoId") Integer torneoId,
            @Param("estado") EstadoInscripcion estado
    );
}