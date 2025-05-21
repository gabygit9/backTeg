package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Representa el nivel de dificultad de un bot.
 * Niveles típicos:
 * - Novato
 * - Balanceado
 * - Experto
 *
 * @author GabrielaCamacho
 * @version 1.0
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NivelBot {
    @Id
    private int id;
    private String nombre;
}
