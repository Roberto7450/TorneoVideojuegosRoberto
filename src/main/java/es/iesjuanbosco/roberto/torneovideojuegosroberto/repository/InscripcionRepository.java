package es.iesjuanbosco.roberto.torneovideojuegosroberto.repository;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Inscripcion;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.InscripcioneId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, InscripcioneId> {

    // RN-04: Verificar si un jugador ya está inscrito en un torneo
    @Query("SELECT CASE WHEN COUNT(i) > 0 THEN true ELSE false END " +
            "FROM Inscripcion i " +
            "WHERE i.jugador.id = :jugadorId AND i.torneo.id = :torneoId")
    boolean existsByJugadorIdAndTorneoId(
            @Param("jugadorId") Integer jugadorId,
            @Param("torneoId") Integer torneoId
    );

    // Listar inscripciones de un torneo
    Page<Inscripcion> findByTorneoId(Integer torneoId, Pageable pageable);

    // Actualizar estado de inscripción
    Optional<Inscripcion> findByJugadorIdAndTorneoId(Integer jugadorId, Integer torneoId);
}