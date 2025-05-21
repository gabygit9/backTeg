package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Representa un evento registrado durante una partida (como ataques, canjes, cumplimiento de objetivo, etc.).
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see Partida
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistorialEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "historial_partida_id")
    private Partida partida;

    private String descripcion;

    @Column(name = "fecha_hora_evento")
    private LocalDateTime fechaHora;
}
