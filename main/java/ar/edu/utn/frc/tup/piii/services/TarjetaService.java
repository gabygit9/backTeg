package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.model.entities.TarjetaJugador;
import ar.edu.utn.frc.tup.piii.model.entities.TarjetaPais;

import java.util.List;

/**
 * Interfaz que define las operaciones relacionadas con las tarjetas de país en el juego.
 * Las tarjetas permiten obtener refuerzos mediante combinaciones válidas y son asignadas
 * como recompensa por conquistas.
 *
 * @author Ismael Ceballos
 */
public interface TarjetaService {

    boolean savePais(TarjetaPais tarjeta);

    boolean updatePais(TarjetaPais tarjeta);

    TarjetaPais findByIdPais(int id);

    List<TarjetaPais> findAllPais();

    boolean saveJugador(TarjetaJugador tarjeta);

    boolean updateJugador(TarjetaJugador tarjeta);

    TarjetaJugador findByIdJugador(int id);

    List<TarjetaJugador> findAllJugador();

    /**
     * Devuelve una tarjeta de país aleatoria que no haya sido asignada.
     *
     * @return TarjetaPais disponible o null si no hay.
     */
    TarjetaPais obtenerTarjetaDisponible();

    /**
     * Asigna una tarjeta de país a un jugador en la partida.
     *
     * @param tarjetaId        Tarjeta de país.
     * @param jugadorPartidaId Jugador que la recibe.
     * @return
     */
    TarjetaPais asignarTarjetaAJugador(int tarjetaId, int jugadorPartidaId);

    /**
     * Marca como usada una tarjeta de jugador (luego de un canje).
     *
     * @param tarjetaJugadorId Tarjeta a marcar como usada.
     */
    void marcarTarjetaComoUsada(int tarjetaJugadorId);

    /**
     * Obtiene todas las tarjetas que posee un jugador en una partida.
     *
     * @param jugadorPartidaId Jugador a consultar.
     * @return Lista de tarjetas en su poder.
     */
    List<TarjetaJugador> obtenerTarjetasDeJugador(int jugadorPartidaId);


    /**
     * Verifica si un jugador tiene una combinación válida de tarjetas para realizar un canje.
     *
     * @param tarjetasIds Lista de tarjetas seleccionadas.
     * @param jugadorPartidaId Jugador que realiza el intento de canje.
     * @return true si es una combinación válida, false si no lo es.
     */
    boolean esCanjeValido(List<Integer> tarjetasIds, int jugadorPartidaId);


}
