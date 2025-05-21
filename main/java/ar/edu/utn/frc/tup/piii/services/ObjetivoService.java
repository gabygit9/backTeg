package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.model.entities.JugadorPartida;
import ar.edu.utn.frc.tup.piii.model.entities.Objetivo;

import java.util.List;

/**
 * Interfaz que define las operaciones relacionadas con la gestión de objetivos del juego.
 *
 * Permite asignar, consultar y verificar el cumplimiento de los objetivos individuales y comunes.
 *
 * @author Ismael Ceballos
 */
public interface ObjetivoService {

    Objetivo findById(int id);

    List<Objetivo> findAll();

    Objetivo save(Objetivo objetivo);
    Objetivo update(Objetivo objetivo);
    void delete(int id);

}
