package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Representa una sesión del juego TEG.
 * Esta clase almacena información general sobre una partida, incluyendo su fecha de
 * inicio, el estado actual, la modalidad de comunicación y el objetivo común.
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see EstadoPartida
 * @see TipoComunicacion
 * @see Objetivo
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fecha_inicio_partida")
    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoPartida estado;

    @ManyToOne
    @JoinColumn(name = "tipo_comunicacion_id")
    private TipoComunicacion tipoComunicacion;

    @ManyToOne
    @JoinColumn(name = "objetivo_comun_id")
    private Objetivo objetivoComun;
}
