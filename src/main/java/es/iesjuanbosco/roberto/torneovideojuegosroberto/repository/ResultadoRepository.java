package es.iesjuanbosco.roberto.torneovideojuegosroberto.repository;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Resultado;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.ResultadoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResultadoRepository extends JpaRepository<Resultado, ResultadoId> {

    // Para el endpoint GET /api/torneos/{id}/clasificacion (ordenado por puntuación)
    @Query("SELECT r FROM Resultado r " +
            "WHERE r.torneo.id = :torneoId " +
            "ORDER BY r.puntuacion DESC, r.posicion ASC")
    List<Resultado> findRankingByTorneoId(@Param("torneoId") Integer torneoId);

    // Actualizar resultado de un equipo en un torneo
    Optional<Resultado> findByEquipoIdAndTorneoId(Integer equipoId, Integer torneoId);
}