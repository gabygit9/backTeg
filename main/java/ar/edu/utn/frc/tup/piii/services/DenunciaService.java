package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.model.entities.Denuncia;
import ar.edu.utn.frc.tup.piii.model.entities.JugadorBase;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;

import java.util.List;

/**
 * Interfaz que define los métodos para gestionar denuncias dentro de una partida.
 *
 * Este servicio permite registrar y consultar denuncias realizadas por los jugadores,
 * en el contexto del sistema de comunicación (Fair Play / Vale Todo).
 *
 * @author Ismael Ceballos
 * @version 1.0
 */
public interface DenunciaService {

    boolean save(Denuncia denuncia);

    boolean update(Denuncia denuncia);

    Denuncia findById(int id);

    List<Denuncia> findAll();
    /**
     * Registra una nueva denuncia entre jugadores.
     *
     * @param partida Partida en la que ocurrió la infracción.
     * @param acusador Jugador que realiza la denuncia.
     * @param acusado Jugador denunciado.
     * @param motivo Descripción del motivo de la denuncia.
     * @return La denuncia registrada.
     */
    Denuncia registrarDenuncia(Partida partida, JugadorBase acusador, JugadorBase acusado, String motivo);

    /**
     * Devuelve todas las denuncias realizadas en una partida específica.
     *
     * @param partida Partida consultada.
     * @return Lista de denuncias.
     */
    List<Denuncia> obtenerDenunciasPorPartida(Partida partida);
}
