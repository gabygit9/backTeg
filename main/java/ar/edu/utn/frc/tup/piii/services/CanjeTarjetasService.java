package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.model.entities.CanjeTarjetas;

import java.util.List;

/**
 * Servicio que gestiona la lógica de canje de tarjetas por ejércitos.
 *
 *  @author Ismael Ceballos
 *  @version 1.0
 */
public interface CanjeTarjetasService {

    boolean save(CanjeTarjetas usuario);

    boolean update(CanjeTarjetas usuario);

    CanjeTarjetas findById(int id);

    List<CanjeTarjetas> findAll();

    /**
     * Realiza un canje de tarjetas por ejércitos para el jugador indicado.
     *
     * @param jugadorPartidaId ID del jugador en la partida.
     */
    void realizarCanje(int jugadorPartidaId);

    /**
     * Verifica si el jugador puede realizar un canje en su turno actual.
     *
     * @param jugadorPartidaId ID del jugador en la partida.
     * @return true si puede canjear, false en caso contrario.
     */
    boolean puedeCanjear(int jugadorPartidaId);

    /**
     * Obtiene la cantidad de ejércitos que recibirá un jugador por su próximo canje.
     *
     * @param jugadorPartidaId ID del jugador en la partida.
     * @return Cantidad de ejércitos a otorgar.
     */
    int obtenerEjercitosPorProximoCanje(int jugadorPartidaId);

}
