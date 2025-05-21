package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.model.entities.Continente;

import java.util.List;

/**
 * Interfaz que define los métodos para consultar los continentes.
 *
 * @author GabrielaCamacho
 * @version 1.0
 */
public interface ContinenteService {
    List<Continente> obtenerTodos();
    Continente obtenerPorId(int id);
}
