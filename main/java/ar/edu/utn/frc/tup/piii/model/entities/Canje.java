package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Representa un canje de tarjetas por ejércitos realizado por un jugador
 * durante una partida. Cada canje está vinculado a un jugador (JugadorPartida), está
 * compuesto por varias tarjetas y registra la fecha y la cantidad de ejércitos obtenidos.
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see JugadorPartida
 * @see CanjeTarjetas
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Canje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "jugador_partida_canje_id")
    private JugadorPartida jugadorPartida;

    @Column(name = "fecha_hora_canje")
    private LocalDateTime fechaHora;

    private int cantidadEjercito;

    @OneToMany(mappedBy = "canje", cascade = CascadeType.ALL)
    private List<CanjeTarjetas> tarjetasCanjeadas;
}
