package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Representa una tarjeta específica utilizada en un canje.
 *  Cada canje tiene 3 tarjetas asociadas mediante esta clase.
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see Canje
 * @see TarjetaJugador
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CanjeTarjetas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "canje_id")
    private Canje canje;

    @ManyToOne
    @JoinColumn(name = "tarjeta_jugador_id")
    private TarjetaJugador tarjetaJugador;
}
