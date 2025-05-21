package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

/**
 * Representa un color disponible en el juego.
 * Este color se asigna a un jugador dentro de una partida específica.
 * {@code @author:} Ismael Ceballos
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Color {
    @Id
    private int id;

    private String nombre;
}
