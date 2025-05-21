package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.*;
import lombok.*;

/**
 *  Clase abstracta que representa a un jugador controlado por la IA (bot).
 *  Debe ser extendida por tipos concretos de bots con diferentes estrategias.
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see NivelBot
 * @see JugadorBase
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public abstract class JugadorBot extends JugadorBase {
    @ManyToOne
    @JoinColumn(name = "nivel_bot_id")
    private NivelBot nivelBot;
}
