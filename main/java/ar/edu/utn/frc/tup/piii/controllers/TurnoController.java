package ar.edu.utn.frc.tup.piii.controllers;

import ar.edu.utn.frc.tup.piii.model.entities.JugadorPartida;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;
import ar.edu.utn.frc.tup.piii.model.entities.Turno;
import ar.edu.utn.frc.tup.piii.services.TurnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST que gestiona las operaciones relacionadas con los turnos
 * de cada jugador en una partida del juego TEG.
 *
 * Incluye endpoints para:
 * - Crear y actualizar turnos
 * - Iniciar un turno
 * - Pasar de fase
 * - Consultar acciones disponibles
 * - Finalizar turno
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see TurnoService
 * @see Turno
 * @see JugadorPartida
 * @see Partida
 */
//TODO agregar manejo de excepciones y respuestas HTTP más detalladas
//TODO usar responseEntity<?> en la firma de todos los métodos
@RestController
@RequestMapping("/api/v1/turnos")
@RequiredArgsConstructor
public class TurnoController {
    private final TurnoService turnoService;
    /**
     * Guarda un nuevo turno.
     */
    @PostMapping
    public ResponseEntity<Boolean> save(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.save(turno));
    }

    /**
     * Actualiza un turno existente.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable int id, @RequestBody Turno turno) {
        turno.setId(id);
        return ResponseEntity.ok(turnoService.update(turno));
    }

    /**
     * Busca un turno por su ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Turno> findById(@PathVariable int id) {
        return ResponseEntity.ok(turnoService.findById(id));
    }

    /**
     * Devuelve todos los turnos registrados.
     */
    @GetMapping
    public ResponseEntity<List<Turno>> findAll() {
        return ResponseEntity.ok(turnoService.findAll());
    }

    /**
     * Inicia un nuevo turno para un jugador en una partida.
     */
    @PostMapping("/iniciar")
    public ResponseEntity<Void> iniciarTurno(@RequestParam int jugadorPartidaId, @RequestParam int partidaId) {
        JugadorPartida jugador = new JugadorPartida();
        jugador.setId(jugadorPartidaId);
        Partida partida = new Partida();
        partida.setId(partidaId);
        turnoService.iniciarTurno(jugador, partida);
        return ResponseEntity.ok().build();
    }

    /**
     * Cambia a la siguiente fase del turno actual.
     */
    @PostMapping("/{id}/pasar-fase")
    public ResponseEntity<Void> pasarFase(@PathVariable int id) {
        Turno turno = turnoService.findById(id);
        turnoService.pasarFase(turno);
        return ResponseEntity.ok().build();
    }

    /**
     * Retorna las acciones disponibles en la fase actual del turno.
     */
    @GetMapping("/{id}/acciones-disponibles")
    public ResponseEntity<List<String>> obtenerAccionesDisponibles(@PathVariable int id) {
        Turno turno = turnoService.findById(id);
        return ResponseEntity.ok(turnoService.obtenerAccionesDisponibles(turno));
    }

    /**
     * Finaliza el turno actual y pasa al siguiente jugador.
     */
    @PostMapping("/{id}/finalizar")
    public ResponseEntity<Void> finalizarTurno(@PathVariable int id) {
        Turno turno = turnoService.findById(id);
        turnoService.finalizarTurno(turno);
        return ResponseEntity.ok().build();
    }
}
