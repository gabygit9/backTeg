package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/**
 *  Representa un jugador bot con comportamiento novato:
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
public class JugadorBotNovato extends JugadorBot{
}
