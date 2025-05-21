package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.Entity;
import lombok.*;

/**
 *  Representa un jugador bot con comportamiento balanceado:
 *  evalúa probabilidades antes de atacar y reparte tropas estratégicamente.
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see JugadorBot
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class JugadorBotBalanceado  extends JugadorBot{

}
