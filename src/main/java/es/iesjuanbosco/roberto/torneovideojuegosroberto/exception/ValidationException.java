package es.iesjuanbosco.roberto.torneovideojuegosroberto.exception;

/**
 * Excepción para VALIDACIONES de reglas de negocio
 * Usada en:
 * - RN-02: Equipo no tiene X miembros
 * - RN-03: Torneo lleno
 * - RN-05: Fechas incoherentes
 *
 * El GlobalExceptionHandler la captura y devuelve 400 Bad Request
 */
public class ValidationException extends RuntimeException {
    public ValidationException(String mensaje) {
        super(mensaje);
    }
}