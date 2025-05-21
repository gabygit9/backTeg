package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Representa un mensaje enviado por un jugador durante una partida.
 * Puede ser parte del sistema de chat o comunicación entre jugadores.
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see Partida
 * @see JugadorBase
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "mensaje_partida_id", nullable = false)
    private Partida partida;

    @ManyToOne
    @JoinColumn(name = "emisor_id", nullable = false)
    private JugadorBase emisor;

    @Column(nullable = false, length = 200)
    private String contenido;

    @Column(name = "fecha_hora_mensaje", nullable = false)
    private LocalDateTime fechaHora;
}
