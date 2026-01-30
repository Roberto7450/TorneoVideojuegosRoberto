package es.iesjuanbosco.roberto.torneovideojuegosroberto.controller;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.EquipoRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.EquipoResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.service.EquipoService;
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
@RequestMapping("/api/equipos")
@RequiredArgsConstructor
@Tag(name = "Equipos", description = "Gestión de equipos")
public class EquipoController {

    private final EquipoService equipoService;

    // GET /api/equipos?page=0&size=10
    @GetMapping
    @Operation(summary = "Listar equipos con paginación")
    public ResponseEntity<Page<EquipoResponseDTO>> listar(Pageable pageable) {
        return ResponseEntity.ok(equipoService.listar(pageable));
    }

    // GET /api/equipos/{id}
    @GetMapping("/{id}")
    @Operation(summary = "Obtener equipo con detalles")
    public ResponseEntity<EquipoResponseDTO> obtenerPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(equipoService.buscarPorId(id));
    }

    // POST /api/equipos
    @PostMapping
    @Operation(summary = "Crear equipo")
    public ResponseEntity<EquipoResponseDTO> crear(@Valid @RequestBody EquipoRequestDTO dto) {
        EquipoResponseDTO creado = equipoService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // PUT /api/equipos/{id}
    @PutMapping("/{id}")
    @Operation(summary = "Actualizar equipo")
    public ResponseEntity<EquipoResponseDTO> actualizar(
            @PathVariable Integer id,
            @Valid @RequestBody EquipoRequestDTO dto) {
        return ResponseEntity.ok(equipoService.actualizar(id, dto));
    }

    // DELETE /api/equipos/{id}
    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar equipo")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        equipoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}