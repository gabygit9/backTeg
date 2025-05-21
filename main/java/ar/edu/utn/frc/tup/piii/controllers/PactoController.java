package ar.edu.utn.frc.tup.piii.controllers;

import ar.edu.utn.frc.tup.piii.model.entities.Pacto;
import ar.edu.utn.frc.tup.piii.services.PactoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO agregar manejo de excepciones y respuestas HTTP más detalladas
//TODO usar responseEntity<?> en la firma de todos los métodos
@RestController
@RequestMapping("/api/v1/pactos")
@RequiredArgsConstructor
public class PactoController {
    private final PactoService pactoService;

    /**
     * Crea un nuevo pacto entre jugadores.
     *
     * @param pacto Objeto Pacto con la información a guardar.
     * @return Pacto creado.
     */
    @PostMapping
    public ResponseEntity<Pacto> crearPacto(@RequestBody Pacto pacto) {
        return ResponseEntity.ok(pactoService.crearPacto(pacto));
    }

    /**
     * Rompe un pacto existente por su ID.
     *
     * @param pactoId ID del pacto a romper.
     * @return true si se rompió correctamente.
     */
    @PostMapping("/{pactoId}/romper")
    public ResponseEntity<Boolean> romperPacto(@PathVariable int pactoId) {
        return ResponseEntity.ok(pactoService.romperPacto(pactoId));
    }

    /**
     * Lista todos los pactos activos de una partida.
     *
     * @param partidaId ID de la partida.
     * @return Lista de pactos activos.
     */
    @GetMapping("/partida/{partidaId}")
    public ResponseEntity<List<Pacto>> obtenerPactosPorPartida(@PathVariable int partidaId) {
        return ResponseEntity.ok(pactoService.obtenerPactosPorPartida(partidaId));
    }
}
