package es.iesjuanbosco.roberto.torneovideojuegosroberto.controller;

import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.request.ResultadoRequestDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.dto.response.ResultadoResponseDTO;
import es.iesjuanbosco.roberto.torneovideojuegosroberto.service.ResultadoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resultados")
@RequiredArgsConstructor
@Tag(name = "Resultados", description = "Gestión de resultados y clasificaciones")
public class ResultadoController {

    private final ResultadoService resultadoService;

    // POST /api/resultados
    @PostMapping
    @Operation(summary = "Registrar resultado de equipo en torneo")
    public ResponseEntity<ResultadoResponseDTO> crear(@Valid @RequestBody ResultadoRequestDTO dto) {
        ResultadoResponseDTO creado = resultadoService.crear(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // PUT /api/resultados/{equipoId}/{torneoId}
    @PutMapping("/{equipoId}/{torneoId}")
    @Operation(summary = "Actualizar resultado (posición y puntuación)")
    public ResponseEntity<ResultadoResponseDTO> actualizar(
            @PathVariable Integer equipoId,
            @PathVariable Integer torneoId,
            @Valid @RequestBody ResultadoRequestDTO dto) {
        return ResponseEntity.ok(resultadoService.actualizar(equipoId, torneoId, dto));
    }

    // GET /api/resultados/torneo/{torneoId}/ranking
    @GetMapping("/torneo/{torneoId}/ranking")
    @Operation(summary = "Obtener ranking del torneo ordenado por puntuación")
    public ResponseEntity<List<ResultadoResponseDTO>> obtenerRanking(@PathVariable Integer torneoId) {
        return ResponseEntity.ok(resultadoService.obtenerRanking(torneoId));
    }

    // DELETE /api/resultados/{equipoId}/{torneoId}
    @DeleteMapping("/{equipoId}/{torneoId}")
    @Operation(summary = "Eliminar resultado")
    public ResponseEntity<Void> eliminar(
            @PathVariable Integer equipoId,
            @PathVariable Integer torneoId) {
        resultadoService.eliminar(equipoId, torneoId);
        return ResponseEntity.noContent().build();
    }
}