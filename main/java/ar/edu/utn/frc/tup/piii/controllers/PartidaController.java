package ar.edu.utn.frc.tup.piii.controllers;

import ar.edu.utn.frc.tup.piii.model.entities.Pacto;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;
import ar.edu.utn.frc.tup.piii.services.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//TODO agregar manejo de excepciones y respuestas HTTP más detalladas
//TODO usar responseEntity<?> en la firma de todos los métodos
/**
 * Controlador REST para gestionar operaciones relacionadas con la entidad Partida.
 * Permite iniciar, continuar, finalizar partidas, consultar información y manejar lógica general del juego.
 *
 * @author GabrielaCamacho
 */
@RestController
@RequestMapping("/api/v1/partidas")
public class PartidaController {
    private final PartidaService partidaService;

    @Autowired
    public PartidaController(PartidaService partidaService) {
        this.partidaService = partidaService;
    }

    /**
     * Inicia una nueva partida con los datos recibidos.
     *
     * @param partida Objeto partida con la configuración inicial.
     * @return La partida creada.
     */
    @PostMapping("/iniciar")
    public boolean iniciarPartida(@RequestBody Partida partida) {
        return partidaService.iniciarPartida(partida);
    }

    /**
     * Continúa una partida pausada (por ID).
     *
     * @param id Identificador de la partida.
     * @return La partida actualizada.
     */
    @PutMapping("/continuar/{id}")
    public boolean continuarPartida(@PathVariable int id) {
        return partidaService.continuarPartida(id);
    }

    /**
     * Finaliza una partida por ID.
     * @param id ID de la partida.
     * @return Mensaje de confirmación.
     */
    @PutMapping("/finalizar/{id}")
    public void finalizarPartida(@PathVariable int id) {
        partidaService.finalizarPartida(id);
    }

    /**
     * Obtiene una lista de todas las partidas activas.
     * @return Lista de partidas.
     */
    @GetMapping
    public List<Partida> obtenerPartidas() {
        return partidaService.findAll();
    }

    /**
     * Recupera una partida específica por ID.
     * @param id ID de la partida.
     * @return La partida encontrada, o null.
     */
    @GetMapping("/{id}")
    public Partida obtenerPorId(@PathVariable int id) {
        return partidaService.findById(id);
    }

    /**
     * Guarda el estado actual de una partida.
     * @param id ID de la partida.
     */
    @PostMapping("/guardar/{id}")
    public void guardarEstado(@PathVariable int id) {
        partidaService.guardarEstado(id);
    }

    /**
     * Carga el estado de una partida desde almacenamiento persistido.
     * @param id ID de la partida.
     */
    @PostMapping("/cargar/{id}")
    public void cargarEstado(@PathVariable int id) {
        partidaService.cargarEstado(id);
    }

    /**
     * Reparte las tarjetas de país entre los jugadores de la partida.
     *
     * @param id ID de la partida.
     */
    @PostMapping("/{id}/repartir-tarjetas")
    public void repartirTarjetas(@PathVariable int id) {
        partidaService.repartirTarjetas(id);
    }

    /**
     * Simula una tirada de dados entre dos países.
     *
     * @param atacantePaisId ID del país atacante.
     * @param defensorPaisId ID del país defensor.
     */
    @PostMapping("/{id}/tirar-dados")
    public void tirarDados(@RequestParam int atacantePaisId, @RequestParam int defensorPaisId) {
        partidaService.tirarDados(atacantePaisId, defensorPaisId);
    }

    /**
     * Verifica si dos países son limítrofes (adyacentes).
     *
     * @param pais1 ID del primer país.
     * @param pais2 ID del segundo país.
     * @return true si son limítrofes, false si no.
     */
    @GetMapping("/{id}/es-limitrofe")
    public boolean esLimitrofe( @RequestParam int pais1, @RequestParam int pais2) {
        return partidaService.esLimitrofe(pais1, pais2);
    }

    /**
     * Anuncia un ataque desde un país a otro.
     *
     * @param origenId ID del país atacante.
     * @param destinoId ID del país defensor.
     */
    @PostMapping("/{id}/anunciar-ataque")
    public void anunciarAtaque(@RequestParam int origenId, @RequestParam int destinoId) {
        partidaService.anunciarAtaque(origenId, destinoId);
    }

    /**
     * Retira tropas de un país.
     *
     * @param paisId ID del país.
     * @param cantidad Cantidad de tropas a retirar.
     */
    @PostMapping("/{paisId}/retirar-ejercito")
    public void retirarEjercito(@RequestParam int paisId, @RequestParam int cantidad) {
        partidaService.retirarEjercito(paisId, cantidad);
    }

    /**
     * Registra que un jugador ha conquistado un país.
     *
     * @param paisId ID del país conquistado.
     * @param jugadorId ID del jugador conquistador.
     */
    @PostMapping("/{id}/conquistar-pais")
    public void conquistarPais(@RequestParam int paisId, @RequestParam int jugadorId) {
        partidaService.conquistarPais(paisId,jugadorId);
    }

    /**
     * Incorpora nuevos ejércitos al jugador actual en la partida.
     *
     * @param id ID de la partida.
     */
    @PostMapping("/{id}/incorporar-ejercito")
    public void incorporarEjercito(@PathVariable int id) {
        partidaService.incorporarEjercito(id);
    }

    /**
     * Devuelve los continentes ocupados por completo por el jugador actual.
     *
     * @param id ID de la partida.
     * @return Lista de nombres de continentes ocupados.
     */
    @GetMapping("/{id}/continente-ocupado")
    public List<String> continenteOcupado(@PathVariable int id) {
        return partidaService.continenteOcupado(id);
    }

    /**
     * Devuelve los pactos activos en la partida.
     *
     * @param id ID de la partida.
     * @return Lista de pactos.
     */
    @GetMapping("/{id}/ver-pactos")
    public List<Pacto> verPactos(@PathVariable int id) {
        return partidaService.verPactos(id);
    }

    /**
     * Devuelve el tipo de comunicación configurado para la partida.
     *
     * @param id ID de la partida.
     * @return Descripción del estilo de comunicación (ej. "Fair Play").
     */
    @GetMapping("/{id}/comunicacion")
    public String estiloComunicacion(@PathVariable int id) {
        return partidaService.estiloComunicacion(id);
    }

    /**
     * Inicia la fase de hostilidades en una partida.
     *
     * @param partidaId ID de la partida.
     */
    @PostMapping("/{id}/iniciar-hostilidades")
    public void iniciarHostilidades(@PathVariable int partidaId){
        partidaService.iniciarHostilidades(partidaId);
    }

    /**
     * Registra a un jugador para participar en una partida.
     *
     * @param partidaId ID de la partida.
     * @param jugadorId ID del jugador.
     * @return true si el registro fue exitoso.
     */
    @PostMapping("/{partidaId}/registrar-jugador/{jugadorId}")
    public boolean registrarJugador(@PathVariable int partidaId, @PathVariable int jugadorId){
        return partidaService.registrarJugador(partidaId, jugadorId);
    }

    /**
     * Asigna objetivos secretos a todos los jugadores de una partida.
     *
     * @param partidaId ID de la partida.
     */
    @PostMapping("/{partidaId}/asignar-objetivos-secretos")
    public ResponseEntity<Void> asignarObjetivosSecretos(@PathVariable int partidaId) {
        partidaService.asignarObjetivosSecretos(partidaId);
        return ResponseEntity.ok().build();
    }

    /**
     * Asigna el objetivo común a una partida.
     *
     * @param partidaId ID de la partida.
     * @param objetivoId ID del objetivo común.
     */
    @PostMapping("/{partidaId}/asignar-objetivo-comun/{objetivoId}")
    public ResponseEntity<Void> asignarObjetivoComun(@PathVariable int partidaId, @PathVariable int objetivoId) {
        partidaService.asignarObjetivoComun(partidaId, objetivoId);
        return ResponseEntity.ok().build();
    }


}
