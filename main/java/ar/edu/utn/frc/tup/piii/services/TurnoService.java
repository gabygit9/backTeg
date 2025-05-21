package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.model.entities.JugadorPartida;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;
import ar.edu.utn.frc.tup.piii.model.entities.Turno;

import java.util.List;

/**
 * Interfaz que define las operaciones relacionadas con la gestión de turnos en una partida.
 * Un turno está compuesto por distintas fases del juego: incorporación, ataque y reagrupación.
 *
 * @author Ismael Ceballos
 */
public interface TurnoService {

    boolean save(Turno turno);

    boolean update(Turno turno);

    Turno findById(int id);

    List<Turno> findAll();

    /**
     * Inicia un nuevo turno para el jugador actual.
     * @param jugadorPartida El jugador que debe comenzar el turno.
     * @param partida La partida en curso.
     */
    void iniciarTurno(JugadorPartida jugadorPartida, Partida partida);

    /**
     * Avanza a la siguiente fase del turno actual (incorporación → ataque → reagrupación).
     * @param turno Turno actual.
     */
    void pasarFase(Turno turno);

    /**
     * Retorna las acciones disponibles en la fase actual del turno.
     * @param turno Turno en curso.
     * @return Lista de acciones permitidas.
     */
    List<String> obtenerAccionesDisponibles(Turno turno);

    /**
     * Finaliza el turno actual y pasa el control al siguiente jugador.
     * @param turno Turno a finalizar.
     */
    void finalizarTurno(Turno turno);

}
