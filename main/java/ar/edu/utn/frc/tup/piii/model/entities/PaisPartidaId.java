package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class PaisPartidaId implements Serializable {
    private int pais;
    private int partida;
}
