package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa un continente en el tablero del juego
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Continente {
    @Id
    private int id;

    private String nombre;

    @Column(name = "ejercito_bonus")
    private int ejercitoBonus;
}
