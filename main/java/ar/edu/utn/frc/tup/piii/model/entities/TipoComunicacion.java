package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa el tipo de comunicación permitida entre los jugadores
 * durante una partida del juego.
 *
 * Ejemplos de tipos de comunicación:
 * - Fair_Play
 * - Vale_Todo
 *
 * Los valores suelen estar precargados en la base de datos.
 *
 * @author GabrielaCamacho
 * @version 1.0
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoComunicacion {

    @Id
    private int id;
    private String descripcion;
}
