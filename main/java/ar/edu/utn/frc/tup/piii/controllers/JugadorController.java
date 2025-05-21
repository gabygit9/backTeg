package ar.edu.utn.frc.tup.piii.controllers;

import ar.edu.utn.frc.tup.piii.model.entities.JugadorBase;
import ar.edu.utn.frc.tup.piii.model.entities.JugadorPartida;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;
import ar.edu.utn.frc.tup.piii.services.JugadorService;
import ar.edu.utn.frc.tup.piii.services.PartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO agregar manejo de excepciones y respuestas HTTP más detalladas
//TODO usar responseEntity<?> en la firma de todos los métodos
/**
 * Esta clase es el controlador de la clase jugador donde se realizaran los endpoints de la API REST
 * {@code @author:} Ismael Ceballos
 */
@RestController
@RequestMapping("/api/v1/jugadores")
@RequiredArgsConstructor
public class JugadorController {

    private final JugadorService jugadorService;
    private final PartidaService partidaService;

    /**
     * Obtiene la lista de todos los jugadores.
     *
     * @return Lista de jugadores.
     */
    @GetMapping
    public ResponseEntity<List<JugadorBase>> obtenerTodos() {
        return ResponseEntity.ok(jugadorService.findAll());
    }

    /**
     * Obtiene un jugador por su ID.
     *
     * @param id ID del jugador.
     * @return Jugador correspondiente o 404 si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<JugadorBase> obtenerPorId(@PathVariable int id) {
        JugadorBase jugador = jugadorService.findById(id);
        return (jugador != null) ? ResponseEntity.ok(jugador) : ResponseEntity.notFound().build();
    }

    /**
     * Registra un jugador en una partida específica con un orden de turno.
     *
     * @param jugador    Jugador a registrar.
     * @param partidaId    Partida a la que se incorpora.
     * @param ordenTurno Orden del turno del jugador.
     * @return Asociación jugador-partida creada.
     */
    @PostMapping("/registrar")
    public ResponseEntity<?> registrarEnPartida(@RequestBody JugadorBase jugador,
                                                     @RequestParam int partidaId,
                                                     @RequestParam int ordenTurno) {
        Partida partida = partidaService.findById(partidaId);
        if (partida == null) {
            return ResponseEntity.badRequest().body("Partida no encontrada");
        }
        JugadorPartida jp = jugadorService.registrarJugadorEnPartida(jugador, partidaId, ordenTurno);
        return ResponseEntity.ok(jp);
    }

    /**
     * Obtiene todos los jugadores de una partida.
     *
     * @param partida Partida para la cual se desean los jugadores.
     * @return Lista de jugadores participantes.
     */
    @GetMapping("/partida")
    public ResponseEntity<List<JugadorPartida>> jugadoresPorPartida(@RequestParam Partida partida) {
        return ResponseEntity.ok(jugadorService.obtenerJugadoresDePartida(partida));
    }

    /**
     * Guarda un nuevo jugador.
     *
     * @param jugador Jugador a guardar.
     * @return true si se guardó correctamente.
     */
    @PostMapping
    public ResponseEntity<Boolean> guardarJugador(@RequestBody JugadorBase jugador) {
        return ResponseEntity.ok(jugadorService.save(jugador));
    }

    /**
     * Actualiza un jugador existente.
     *
     * @param jugador Jugador actualizado.
     * @return true si se actualizó correctamente.
     */
    @PutMapping
    public ResponseEntity<Boolean> actualizarJugador(@RequestBody JugadorBase jugador) {
        return ResponseEntity.ok(jugadorService.update(jugador));
    }

    @GetMapping("/objetivo-cumplido/{jugadorPartidaId}")
    public ResponseEntity<Boolean> verificarObjetivoCumplido(@PathVariable int jugadorPartidaId) {
        boolean cumplido = jugadorService.cumplioObjetivo(jugadorPartidaId);
        return ResponseEntity.ok(cumplido);
    }

}
