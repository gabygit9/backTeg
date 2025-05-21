package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa un símbolo asociado a una tarjeta de país.
 *  Ejemplos de símbolos:
 *  - Cañón
 *  - Globo
 *  - Galeón
 *
 * @author GabrielaCamacho
 * @version 1.0
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Simbolo {
    @Id
    private int id;
    private String tipo;
}
