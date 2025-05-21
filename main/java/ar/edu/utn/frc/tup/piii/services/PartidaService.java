package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.model.entities.Pacto;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Interface que define las operaciones principales sobre la entidad Partida.
 * Representa la capa de servicio que gestiona la lógica relacionada a las partidas del juego.
 *
 * @author Ismael Ceballos
 */
public interface PartidaService {

    boolean save(Partida partida);

    boolean update(Partida partida);

    Partida findById(int id);

    List<Partida> findAll();

    /**
     * Inicia una partida desde el estado "Preparación".
     * Asigna países, jugadores, objetivos, etc.
     *
     * @param partidaId ID de la partida
     * @return true si se inició correctamente
     */
    boolean iniciarPartida(Partida partidaId);

    /**
     * Permite continuar una partida que fue pausada.
     *
     * @param partidaId ID de la partida
     * @return true si se reanudó exitosamente
     */
    boolean continuarPartida(int partidaId);

    /**
     * Finaliza una partida estableciendo su estado como "Finalizada".
     *
     * @param partidaId ID de la partida
     * @return true si se finalizó correctamente
     */
    boolean finalizarPartida(int partidaId);

    /**
     * Cambia la partida al estado de hostilidades: comienzan los turnos.
     *
     * @param partidaId ID de la partida
     */
    void iniciarHostilidades(int partidaId);

    /**
     * Reparte las tarjetas iniciales de país y objetivo secreto a cada jugador.
     *
     * @param partidaId ID de la partida
     */
    void repartirTarjetas(int partidaId);

    /**
     * Registra un nuevo jugador en una partida en preparación.
     *
     * @param partidaId ID de la partida
     * @param jugadorId ID del jugador
     * @return true si se registró correctamente
     */
    boolean registrarJugador(int partidaId, int jugadorId);


    /**
     * Lógica para tirar los dados en una batalla.
     *
     * @param atacanteId ID del jugador atacante
     * @param defensorId ID del jugador defensor
     * @return resultado del dado como objeto o lista
     */
    List<Integer> tirarDados(int atacanteId, int defensorId);

    /**
     * Verifica si dos países son limítrofes (conectados).
     *
     * @param paisId1 ID del primer país
     * @param paisId2 ID del segundo país
     * @return true si son vecinos
     */
    boolean esLimitrofe(int paisId1, int paisId2);

    /**
     * Permite anunciar el ataque entre dos países.
     *
     * @param origenId país atacante
     * @param destinoId país defensor
     */
    void anunciarAtaque(int origenId, int destinoId);

    /**
     * Permite al jugador retirar ejército del país atacado luego de la victoria.
     *
     * @param paisId ID del país
     * @param cantidad cantidad de tropas
     */
    void retirarEjercito(int paisId, int cantidad);

    /**
     * Registra la conquista de un país por parte de un jugador.
     *
     * @param paisId ID del país conquistado
     * @param jugadorId ID del nuevo jugador propietario
     */
    void conquistarPais(int paisId, int jugadorId);

    /**
     * Incorpora tropas disponibles al comienzo de un turno.
     *
     * @param jugadorPartidaId ID del jugador
     */
    void incorporarEjercito(int jugadorPartidaId);

    /**
     * Verifica si un continente está completamente ocupado por un jugador.
     *
     * @param jugadorPartidaId ID del jugador
     * @return lista de continentes ocupados
     */
    List<String> continenteOcupado(int jugadorPartidaId);

    /**
     * Obtiene los pactos activos en una partida.
     *
     * @param partidaId ID de la partida
     * @return lista de pactos
     */
    List<Pacto> verPactos(int partidaId);

    /**
     * Devuelve el tipo de comunicación activa (Fair Play, Vale Todo).
     *
     * @param partidaId ID de la partida
     * @return descripción del estilo de comunicación
     */
    String estiloComunicacion(int partidaId);

    /**
     * Guarda el estado actual de la partida (para reinicio futuro).
     *
     * @param partidaId ID de la partida
     */
    void guardarEstado(int partidaId);

    /**
     * Carga el estado guardado previamente de una partida.
     *
     * @param partidaId ID de la partida
     * @return
     */
    Partida cargarEstado(int partidaId);

    /**
     * Asigna objetivos secretos a cada jugador de una partida.
     *
     * Este método obtiene todos los jugadores de la partida y les asigna
     * aleatoriamente un objetivo secreto distinto, asegurándose de que
     * no se asigne el objetivo común como objetivo secreto.
     *
     * @param partidaId ID de la partida a la cual se asignarán los objetivos.
     *
     * @throws NoSuchElementException si la partida no existe o no hay suficientes objetivos disponibles.
     */
    void asignarObjetivosSecretos(int partidaId);

    /**
     * Asigna un objetivo común a una partida.
     *
     * Este objetivo es visible para todos los jugadores y se guarda en la partida como referencia.
     *
     * @param partidaId ID de la partida en la que se asignará el objetivo.
     * @param objetivoComunId ID del objetivo que se utilizará como objetivo común.
     *
     * @throws NoSuchElementException si la partida o el objetivo no existen.
     */
    void asignarObjetivoComun(int partidaId, int objetivoComunId);

}
