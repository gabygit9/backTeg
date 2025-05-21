package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Representa una tarjeta de país que ha sido entregada a un jugador
 *  en una partida determinada. Estas tarjetas pueden ser canjeadas
 *  por ejércitos si cumplen las reglas de combinación.
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see TarjetaPais
 * @see JugadorPartida
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarjetaJugador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "tarjeta_pais_id")
    private TarjetaPais tarjetaPais;

    @ManyToOne
    @JoinColumn(name = "jugador_partida_id")
    private JugadorPartida jugadorPartida;

    private boolean usada;
}
