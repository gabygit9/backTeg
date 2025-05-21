package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Esta clase representa el objetivo secreto de un jugador dentro de una partida.
 * {@code @author:} Ismael Ceballos
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Objetivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String descripcion;
}
