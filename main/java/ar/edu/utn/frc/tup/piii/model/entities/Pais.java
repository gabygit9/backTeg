package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Representa un país del mapa en el juego TEG.
 *  Cada país pertenece a un continente.
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see Continente
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pais {
    @Id
    private int id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "continente_pais_id", nullable = false)
    private Continente continente;
}
