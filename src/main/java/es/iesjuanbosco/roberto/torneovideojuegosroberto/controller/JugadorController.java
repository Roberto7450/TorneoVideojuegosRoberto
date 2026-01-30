package es.iesjuanbosco.roberto.torneovideojuegosroberto.controller;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.JugadorRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.JugadorResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.service.JugadorService;
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
@RequestMapping("/api/jugadores")
@RequiredArgsConstructor
@Tag(name = "Jugadores", description = "Gestión de jugadores")
public class JugadorController {

    private final JugadorService jugadorService;

    // GET /api/jugadores?page=0&size=10
    @GetMapping
    @Operation(summary = "Listar jugadores con paginación")
    public ResponseEntity<Page<JugadorResponseDTO>> listar(Pageable pageable) {
        return ResponseEntity.ok(jugadorService.listar(pageable));
    }

    // GET /api/jugadores/{id}
    @GetMapping("/{id}")
    @Operation(summary = "Obtener jugador por ID")
    public ResponseEntity<JugadorResponseDTO> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(jugadorService.buscarPorId(id));
    }

    // POST /api/jugadores
    @PostMapping
    @Operation(summary = "Registrar nuevo jugador")
    public ResponseEntity<JugadorResponseDTO> crear(@Valid @RequestBody JugadorRequestDTO dto) {
        JugadorResponseDTO creado = jugadorService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // PUT /api/jugadores/{id}
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar jugador")
    public ResponseEntity<JugadorResponseDTO> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody JugadorRequestDTO dto) {
        return ResponseEntity.ok(jugadorService.actualizar(id, dto));
    }

    // DELETE /api/jugadores/{id}
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar jugador")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        jugadorService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}