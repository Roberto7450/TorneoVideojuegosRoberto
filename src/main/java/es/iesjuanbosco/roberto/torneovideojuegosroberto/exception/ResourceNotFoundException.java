package es.iesjuanbosco.roberto.torneovideojuegosroberto.exception;

/**
 * Excepción para cuando NO se encuentra un recurso (jugador, equipo, torneo, etc.)
 * El GlobalExceptionHandler la captura y devuelve 404 Not Found
 */
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
    }
}