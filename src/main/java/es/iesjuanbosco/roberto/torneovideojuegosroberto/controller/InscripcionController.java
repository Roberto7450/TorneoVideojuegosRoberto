package es.iesjuanbosco.roberto.torneovideojuegosroberto.controller;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.InscripcionRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.InscripcionResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.enums.EstadoInscripcion;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.service.InscripcionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inscripciones")
@RequiredArgsConstructor
@Tag(name = "Inscripciones", description = "Gestión de inscripciones de jugadores en torneos")
public class InscripcionController {

    private final InscripcionService inscripcionService;

    // POST /api/inscripciones
    @PostMapping
    @Operation(summary = "Inscribir jugador en torneo")
    public ResponseEntity<InscripcionResponseDTO> crear(@Valid @RequestBody InscripcionRequestDTO dto) {
        InscripcionResponseDTO creada = inscripcionService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    // GET /api/inscripciones/torneo/{torneoId}
    @GetMapping("/torneo/{torneoId}")
    @Operation(summary = "Listar inscripciones de un torneo con paginación")
    public ResponseEntity<Page<InscripcionResponseDTO>> listarPorTorneo(
            @PathVariable Integer torneoId,
            Pageable pageable) {
        return ResponseEntity.ok(inscripcionService.listarPorTorneo(torneoId, pageable));
    }

    // PATCH /api/inscripciones/{jugadorId}/{torneoId}/estado?estado=CONFIRMADA
    @PatchMapping("/{jugadorId}/{torneoId}/estado")
    @Operation(summary = "Cambiar estado de inscripción")
    public ResponseEntity<InscripcionResponseDTO> cambiarEstado(
            @PathVariable Integer jugadorId,
            @PathVariable Integer torneoId,
            @RequestParam EstadoInscripcion estado) {
        return ResponseEntity.ok(inscripcionService.cambiarEstado(jugadorId, torneoId, estado));
    }

    // DELETE /api/inscripciones/{jugadorId}/{torneoId}
    @DeleteMapping("/{jugadorId}/{torneoId}")
    @Operation(summary = "Eliminar inscripción")
    public ResponseEntity<Void> eliminar(
            @PathVariable Integer jugadorId,
            @PathVariable Integer torneoId) {
        inscripcionService.eliminar(jugadorId, torneoId);
        return ResponseEntity.noContent().build();
    }
}