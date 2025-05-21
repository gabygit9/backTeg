package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * Clase abstracta que representa la estructura base de cualquier jugador (humano o bot).
 *
 * Esta clase será extendida por implementaciones concretas como JugadorHumano o JugadorBot.
 * {@code @author:} Ismael Ceballos
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
public abstract class JugadorBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @Column(name = "ejercito_disponible")
    private int ejercitosDisponibles;

}