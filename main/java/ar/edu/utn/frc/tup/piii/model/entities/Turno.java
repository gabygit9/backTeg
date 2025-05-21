package ar.edu.utn.frc.tup.piii.model.entities;

import ar.edu.utn.frc.tup.piii.model.enums.FaseTurno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 *  Representa un turno dentro de una partida.
 *  Cada turno pertenece a un jugador en una partida específica e indica la fase actual.
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see JugadorPartida
 * @see Partida
 * @see FaseTurno
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "turno_jugador_partida_id", nullable = false)
    private JugadorPartida jugadorPartida;

    @ManyToOne
    @JoinColumn(name = "turno_partida_id", nullable = false)
    private Partida partida;

    private FaseTurno faseActual; /////7VER

    @Column(name = "fecha_inicio_turno", nullable = false)
    private LocalDateTime fechaInicioTurno;

    @Column(name = "duracion_maxima", nullable = false)
    private int duracionMaxima; // en segundos

    @Column(name = "ejercito_disponible", nullable = false)
    private int ejercitosDisponibles;
}
