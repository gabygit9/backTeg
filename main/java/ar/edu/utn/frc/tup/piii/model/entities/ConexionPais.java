package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConexionPais {
    @EmbeddedId
    private ConexionPaisId id;

    @ManyToOne
    @MapsId("paisOrigenId")
    @JoinColumn(name = "pais_origen_id")
    private Pais paisOrigen;

    @ManyToOne
    @MapsId("paisDestinoId")
    @JoinColumn(name = "pais_destino_id")
    private Pais paisDestino;
}
