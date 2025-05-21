package ar.edu.utn.frc.tup.piii.model.interfaces;

import ar.edu.utn.frc.tup.piii.model.entities.Color;
import ar.edu.utn.frc.tup.piii.model.entities.JugadorBase;
import ar.edu.utn.frc.tup.piii.model.entities.Pais;

/**
 * Interfaz que define las acciones que puede realizar un jugador
 * (humano o bot) dentro del juego de TEG.
 * {@code @author:} GabrielaCamacho
 * @see Pais
 */
public interface IJugador {
    void realizarTurno();
    void atacar(Pais origen, Pais destino);
    void reagrupar(Pais origen, Pais destino, int cantidad);
    void desplazarEjercito(Pais origen, Pais destino, int cantidad);
}
