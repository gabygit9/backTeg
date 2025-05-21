package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Representa una tarjeta que está asociada a un país específico y a un símbolo.
 * Estas tarjetas pueden ser entregadas a los jugadores al final de un turno exitoso
 * y son utilizadas para realizar canjes por ejércitos
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see Pais
 * @see Simbolo
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarjetaPais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "pais_id")
    private Pais pais;
    @ManyToOne
    @JoinColumn(name = "simbolo_id")
    private Simbolo simbolo;
}
