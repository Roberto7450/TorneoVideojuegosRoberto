package es.iesjuanbosco.roberto.torneovideojuegosroberto.controller;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.TorneoRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.TorneoResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.service.TorneoService;
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
@RequestMapping("/api/torneos")
@RequiredArgsConstructor
@Tag(name = "Torneos", description = "Gestión de torneos")
public class TorneoController {

    private final TorneoService torneoService;

    // GET /api/torneos?page=0&size=10
    @GetMapping
    @Operation(summary = "Listar torneos con paginación")
    public ResponseEntity<Page<TorneoResponseDTO>> listar(Pageable pageable) {
        return ResponseEntity.ok(torneoService.listar(pageable));
    }

    // GET /api/torneos/buscar?nombre={nombre}&juegoId={id}&page=0
    @GetMapping("/buscar")
    @Operation(summary = "BÚSQUEDA AVANZADA: Buscar torneos por nombre y/o juego con paginación")
    public ResponseEntity<Page<TorneoResponseDTO>> buscar(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) Integer juegoId,
            Pageable pageable) {
        return ResponseEntity.ok(torneoService.buscarPorNombreYJuego(nombre, juegoId, pageable));
    }

    // GET /api/torneos/{id}
    @GetMapping("/{id}")
    @Operation(summary = "Obtener torneo por ID")
    public ResponseEntity<TorneoResponseDTO> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(torneoService.buscarPorId(id));
    }

    // POST /api/torneos
    @PostMapping
    @Operation(summary = "Crear torneo")
    public ResponseEntity<TorneoResponseDTO> crear(@Valid @RequestBody TorneoRequestDTO dto) {
        TorneoResponseDTO creado = torneoService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // PUT /api/torneos/{id}
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar torneo")
    public ResponseEntity<TorneoResponseDTO> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody TorneoRequestDTO dto) {
        return ResponseEntity.ok(torneoService.actualizar(id, dto));
    }

    // DELETE /api/torneos/{id}
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar torneo")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        torneoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}