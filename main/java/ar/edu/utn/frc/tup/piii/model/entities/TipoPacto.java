package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa el tipo de pacto que pueden hacer los jugadores durante una partida.
 *  *
 * Ejemplos:
 * - No agresión
 * - Pacto entre países
 * - Zona internacional
 *
 * @author GabrielaCamacho
 * @version 1.0
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoPacto {
    @Id
    private int id;
    private String descripcion;
}
