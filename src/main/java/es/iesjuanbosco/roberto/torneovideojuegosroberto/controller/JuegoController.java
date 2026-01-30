package es.iesjuanbosco.roberto.torneovideojuegosroberto.controller;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.JuegoRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.JuegoResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.service.JuegoService;
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
@RequestMapping("/api/juegos")
@RequiredArgsConstructor
@Tag(name = "Juegos", description = "Gestión de juegos")
public class JuegoController {

    private final JuegoService juegoService;

    // GET /api/juegos?page=0&size=10
    @GetMapping
    @Operation(summary = "Listar juegos con paginación")
    public ResponseEntity<Page<JuegoResponseDTO>> listar(Pageable pageable) {
        return ResponseEntity.ok(juegoService.listar(pageable));
    }

    // GET /api/juegos/{id}
    @GetMapping("/{id}")
    @Operation(summary = "Obtener juego por ID")
    public ResponseEntity<JuegoResponseDTO> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(juegoService.buscarPorId(id));
    }

    // POST /api/juegos
    @PostMapping
    @Operation(summary = "Crear juego")
    public ResponseEntity<JuegoResponseDTO> crear(@Valid @RequestBody JuegoRequestDTO dto) {
        JuegoResponseDTO creado = juegoService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // PUT /api/juegos/{id}
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar juego")
    public ResponseEntity<JuegoResponseDTO> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody JuegoRequestDTO dto) {
        return ResponseEntity.ok(juegoService.actualizar(id, dto));
    }

    // DELETE /api/juegos/{id}
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar juego")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        juegoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}