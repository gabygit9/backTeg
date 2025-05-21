package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Representa la ocupación y estado de un país en una partida específica.
 *  Indica qué jugador controla el país y cuántos ejércitos hay en él.
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see Pais
 * @see Partida
 * @see JugadorBase
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaisPartida {

    @EmbeddedId
    private PaisPartidaId id;

    @ManyToOne
    @MapsId("pais")
    @JoinColumn(name = "pais_id", nullable = false)
    private Pais pais;

    @ManyToOne
    @MapsId("partida")
    @JoinColumn(name = "partida_pais_id", nullable = false)
    private Partida partida;

    @ManyToOne
    @JoinColumn(name = "jugador_pais_id", nullable = false)
    private JugadorBase jugador;

    @Column(name = "cantidad_ejercito")
    private int cantidadEjercitos;
}
