package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.model.entities.HistorialEvento;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Interfaz que define las operaciones del historial de eventos de una partida.
 *
 * Permite registrar acciones importantes realizadas durante el desarrollo del juego
 * y consultar la cronología de eventos por partida.
 *
 * @author Ismael Ceballos
 */
public interface HistorialService {

    boolean save(HistorialEvento historial);

    boolean update(HistorialEvento historial);

    HistorialEvento findById(int id);

    List<HistorialEvento> findAll();

    /**
     * Registra un evento en el historial de la partida.
     *
     * @param partida Partida donde ocurrió el evento.
     * @param descripcion Descripción del evento (ej: "Jugador X atacó Brasil").
     * @param fechaHora Fecha y hora del evento.
     * @return El evento registrado.
     */
    HistorialEvento registrarEvento(Partida partida, String descripcion, LocalDateTime fechaHora);

    /**
     * Obtiene todos los eventos registrados para una partida.
     *
     * @param partida Partida a consultar.
     * @return Lista de eventos ordenados por fecha.
     */
    List<HistorialEvento> obtenerEventosPorPartida(Partida partida);

}
