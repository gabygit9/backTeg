package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.model.entities.HistorialEvento;
import ar.edu.utn.frc.tup.piii.model.entities.JugadorBase;
import ar.edu.utn.frc.tup.piii.model.entities.JugadorPartida;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;

import java.util.List;

/**
 * Implementación del servicio que gestiona el historial de eventos del juego.
 *
 * Este servicio registra cada acción relevante que ocurre durante una partida
 * (ataques, conquistas, canjes, cumplimiento de objetivos, etc.),
 * permitiendo luego su consulta para revisión o trazabilidad.
 *
 * @see HistorialEvento
 * @see Partida
 *
 * @author Ismael Ceballos
 */

public interface JugadorService {
    JugadorBase findById(int id);

    List<JugadorBase> findAll();

    boolean save(JugadorBase jugador);

    boolean update(JugadorBase jugador);

    /**
     * Registra un nuevo jugador para una partida.
     *
     * @param jugador Jugador a registrar.
     * @param ordenTurno Posición en el orden de turnos.
     * @return Asociación jugador-partida creada.
     */
    JugadorPartida registrarJugadorEnPartida(JugadorBase jugador, int partidaId, int ordenTurno);

    /**
     * Obtiene la lista de jugadores que participan en una partida.
     *
     * @param partida Partida a consultar.
     * @return Lista de jugadores asociados.
     */
    List<JugadorPartida> obtenerJugadoresDePartida(Partida partida);

    /**
     * Verifica si el jugador ha cumplido su objetivo secreto.
     *
     * @param jugadorPartida El jugador dentro de la partida.
     * @return true si se ha cumplido, false si no.
     */
    boolean cumplioObjetivo(int jugadorPartida);

}
