package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 * Esta clase representa la participacion del jugador en una partida especifica del juego.
 * {@code @author:} Ismael Ceballos
 * @see JugadorBase
 * @see Color
 * @see Objetivo
 * @see Partida
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JugadorPartida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "partida_id")
    private Partida partida;

    @ManyToOne
    @JoinColumn(name = "jugador_base_id")
    private JugadorBase jugador;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "objetivo_id")
    private Objetivo objetivoSecreto;

    @Column(name = "objetivo_cumplido")
    private boolean objetivoCumplido;

    @Column(name = "orden_turno")
    private int ordenTurno;

    @Column(name = "es_turno")
    private boolean esTurno;

}
