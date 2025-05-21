package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

/**
 * Representa a un jugador humano dentro del juego.
 * No tiene lógica de IA, las decisiones son tomadas por el usuario.
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see JugadorBase
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class JugadorHumano extends JugadorBase{
}
