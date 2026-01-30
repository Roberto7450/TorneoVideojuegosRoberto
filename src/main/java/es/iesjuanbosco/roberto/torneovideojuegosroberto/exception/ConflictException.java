package es.iesjuanbosco.roberto.torneovideojuegosroberto.exception;

/**
 * Excepción para CONFLICTOS (duplicados, recursos ya existentes)
 * Usada en:
 * - RN-01: Email o nickname duplicados
 * - RN-04: Jugador ya inscrito
 *
 * El GlobalExceptionHandler la captura y devuelve 409 Conflict
 */
public class ConflictException extends RuntimeException {
    public ConflictException(String mensaje) {
        super(mensaje);
    }
}