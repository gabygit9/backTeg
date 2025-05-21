package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.model.entities.JugadorBase;
import ar.edu.utn.frc.tup.piii.model.entities.Pacto;
import ar.edu.utn.frc.tup.piii.model.entities.Pais;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;

import java.util.List;

/**
 * Interfaz que define las operaciones para la gestión de pactos durante la partida.
 *
 * Permite crear, romper, validar pactos y consultar pactos activos.
 *
 * @author Ismael Ceballos
 */
public interface PactoService {

    boolean save(Pacto pacto);

    boolean update(Pacto pacto);

    Pacto findById(int id);

    List<Pacto> findAll();

    /**
     * Crea un nuevo pacto entre jugadores.
     *
     * @param pacto Objeto que contiene los datos del pacto.
     * @return El pacto creado.
     */
    Pacto crearPacto(Pacto pacto);

    /**
     * Rompe (inactiva) un pacto existente por su identificador.
     *
     * @param pactoId Identificador del pacto a romper.
     * @return true si se rompió correctamente, false en caso contrario.
     */
    boolean romperPacto(int pactoId);

    /**
     * Devuelve todos los pactos activos de una partida.
     *
     * @param partidaId ID de la partida.
     * @return Lista de pactos activos relacionados a la partida.
     */
    List<Pacto> obtenerPactosPorPartida(int partidaId);

}
