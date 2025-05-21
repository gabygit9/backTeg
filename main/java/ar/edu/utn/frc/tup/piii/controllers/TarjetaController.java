package ar.edu.utn.frc.tup.piii.controllers;

import ar.edu.utn.frc.tup.piii.model.entities.TarjetaJugador;
import ar.edu.utn.frc.tup.piii.model.entities.TarjetaPais;
import ar.edu.utn.frc.tup.piii.services.TarjetaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO agregar manejo de excepciones y respuestas HTTP más detalladas
//TODO usar responseEntity<?> en la firma de todos los métodos
@RestController
@RequestMapping("/api/v1/tarjetas")
@RequiredArgsConstructor
public class TarjetaController {
    private final TarjetaService tarjetaService;

    /**
     * Devuelve una tarjeta de país aleatoria no asignada.
     * @return TarjetaPais disponible o null si no hay ninguna.
     */
    @GetMapping("/pais/disponible")
    public ResponseEntity<TarjetaPais> obtenerTarjetaDisponible() {
        return ResponseEntity.ok(tarjetaService.obtenerTarjetaDisponible());
    }

    /**
     * Obtiene todas las tarjetas de un jugador en una partida.
     *
     * @param jugadorPartidaId ID del jugador en la partida.
     * @return Lista de tarjetas del jugador.
     */
    @GetMapping("/jugador/{jugadorPartidaId}")
    public ResponseEntity<List<TarjetaJugador>> obtenerTarjetasJugador(@PathVariable int jugadorPartidaId) {
        return ResponseEntity.ok(tarjetaService.obtenerTarjetasDeJugador(jugadorPartidaId));
    }

    /**
     * Canjea una lista de tarjetas para un jugador.
     *
     * @param jugadorPartidaId ID del jugador en la partida.
     * @param tarjetasIds Lista de IDs de tarjetas a canjear.
     * @return true si el canje fue exitoso.
     */
    @PostMapping("/jugador/{jugadorPartidaId}/canjear")
    public ResponseEntity<Boolean> esCanjeValido(
            @RequestParam List<Integer> tarjetasIds,
            @RequestParam int jugadorPartidaId
    ) {
        boolean exito = tarjetaService.esCanjeValido(tarjetasIds, jugadorPartidaId);
        return ResponseEntity.ok(exito);
    }

    /**
     * Asigna una tarjeta a un jugador de una partida.
     * @param tarjetaId ID de la tarjeta.
     * @param jugadorPartidaId ID del jugador.
     */
    @PostMapping("/jugador/{jugadorPartidaId}/asignar")
    public ResponseEntity<TarjetaPais> asignarTarjeta( @RequestParam int tarjetaId,
                                                       @RequestParam int jugadorPartidaId) {
        TarjetaPais tarjeta = tarjetaService.asignarTarjetaAJugador(tarjetaId, jugadorPartidaId);
        return ResponseEntity.ok(tarjeta);
    }

    /**
     * Marca una tarjeta de jugador como usada luego de canjearla.
     * @param tarjetaJugadorId ID de la tarjeta del jugador.
     */
    @PutMapping("/marcar-usada/{tarjetaJugadorId}")
    public ResponseEntity<Void> marcarTarjetaComoUsada(@PathVariable int tarjetaJugadorId) {
        tarjetaService.marcarTarjetaComoUsada(tarjetaJugadorId);
        return ResponseEntity.ok().build();
    }

}
