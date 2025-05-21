package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 *  Representa una denuncia realizada por un jugador hacia otro durante una partida,
 *  en base a la configuración de reglas de comunicación.
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see JugadorBase
 * @see Partida
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Denuncia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "denuncia_partida_id")
    private Partida partida;

    @ManyToOne
    @JoinColumn(name = "acusador_id")
    private JugadorBase acusador;

    @ManyToOne
    @JoinColumn(name = "acusado_id")
    private JugadorBase acusado;

    private String motivo;

    @Column(name = "fecha_hora_denuncia")
    private LocalDateTime fechaHora;
}
