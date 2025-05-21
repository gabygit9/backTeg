package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;
import java.io.Serializable;

@Data
@Embeddable
public class ConexionPaisId implements Serializable {

    private int paisOrigenId;
    private int paisDestinoId;
}
