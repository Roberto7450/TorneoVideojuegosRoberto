package es.iesjuanbosco.roberto.torneovideojuegosroberto.repository;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Juego;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JuegoRepository extends JpaRepository<Juego, Integer> {

    @Query("SELECT j FROM Juego j " +
            "WHERE (:desarrollador IS NULL OR LOWER(j.desarrollador) LIKE LOWER(CONCAT('%', :desarrollador, '%'))) " +
            "AND (:genero IS NULL OR LOWER(j.genero) LIKE LOWER(CONCAT('%', :genero, '%')))")
    Page<Juego> buscarPorDesarrolladorYGenero(
            @Param("desarrollador") String desarrollador,
            @Param("genero") String genero,
            Pageable pageable
    );
}