package ar.edu.utn.frc.tup.piii.controllers;

import ar.edu.utn.frc.tup.piii.model.entities.Objetivo;
import ar.edu.utn.frc.tup.piii.services.ObjetivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO agregar manejo de excepciones y respuestas HTTP más detalladas
//TODO usar responseEntity<?> en la firma de todos los métodos
/**
 * Controlador REST para la gestión de objetivos del juego.
 * Permite operaciones CRUD sobre los objetivos secretos y comunes.
 *
 * @author GabrielaCamacho
 */
@RestController
@RequestMapping("/api/v1/objetivos")
@RequiredArgsConstructor
public class ObjetivoController {
    private final ObjetivoService objetivoService;

    /**
     * Obtiene la lista de todos los objetivos registrados.
     */
    @GetMapping
    public ResponseEntity<List<Objetivo>> getAll() {
        return ResponseEntity.ok(objetivoService.findAll());
    }

    /**
     * Busca un objetivo por su ID.
     *
     * @param id Identificador del objetivo.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Objetivo> getById(@PathVariable int id) {
        Objetivo objetivo = objetivoService.findById(id);
        return objetivo != null ? ResponseEntity.ok(objetivo) : ResponseEntity.notFound().build();
    }

    /**
     * Registra un nuevo objetivo.
     *
     * @param objetivo Objeto recibido con la información del objetivo.
     */
    @PostMapping
    public ResponseEntity<Objetivo> create(@RequestBody Objetivo objetivo) {
        return ResponseEntity.ok(objetivoService.save(objetivo));
    }

    /**
     * Actualiza un objetivo existente.
     *
     * @param objetivo Objeto actualizado.
     */
    @PutMapping
    public ResponseEntity<Objetivo> update(@RequestBody Objetivo objetivo) {
        return ResponseEntity.ok(objetivoService.update(objetivo));
    }

    /**
     * Elimina un objetivo por su ID.
     *
     * @param id Identificador del objetivo a eliminar.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        objetivoService.delete(id);
        return ResponseEntity.ok().build();
    }
}
