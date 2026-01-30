package es.iesjuanbosco.roberto.torneovideojuegosroberto.repository;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.entity.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JugadorRepository extends JpaRepository<Jugador, Integer> {

    // RN-01: Unicidad de email y nickname
    boolean existsByEmail(String email);
    boolean existsByNickname(String nickname);

    // Buscar jugador por email
    Optional<Jugador> findByEmail(String email);
}