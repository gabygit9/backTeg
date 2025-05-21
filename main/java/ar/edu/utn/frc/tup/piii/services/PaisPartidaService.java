package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.model.entities.*;

import java.util.List;

/**
 * Interfaz que define las operaciones para la gestión de la relación entre países y partidas.
 *
 * Este servicio permite registrar, actualizar y consultar el estado de los países en cada partida.
 *
 * @author Ismael Ceballos
 */
public interface PaisPartidaService {

    boolean save(PaisPartida partida);

    boolean update(PaisPartida partida);

    PaisPartida findById(int id);

    List<PaisPartida> findAll();

    /**
     * Busca todos los países ocupados por un jugador.
     */
    List<PaisPartida> findByJugador(JugadorBase jugador);

    /**
     * Retorna todos los países ocupados por un jugador en una partida específica.
     */
    List<PaisPartida> findByPartidaAndJugador(Partida partida, JugadorBase jugador);

    /**
     * Retorna todos los países de una partida (sin importar el jugador).
     */
    List<PaisPartida> findByPartida(Partida partida);

    /**
     * Incrementa la cantidad de ejércitos en un país específico.
     */
    void aumentarEjercitos(PaisPartidaId id, int cantidad);
}
