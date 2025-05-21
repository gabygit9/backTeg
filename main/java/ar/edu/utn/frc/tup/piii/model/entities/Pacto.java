package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 *  Representa un pacto entre jugadores durante una partida.
 *  Puede establecer condiciones como no agresión, zonas protegidas, etc.
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see JugadorBase
 * @see Partida
 * @see TipoPacto
 * @see Pais
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "pacto_ partida_id")
    private Partida partida;

    @ManyToOne
    @JoinColumn(name = "tipo_pacto_id")
    private  TipoPacto tipoPacto;

    @ManyToMany
    @JoinTable(
            name = "jugadores_pacto",
            joinColumns = @JoinColumn(name = "pacto_id"),
            inverseJoinColumns = @JoinColumn(name = "jugador_base_id")
    )
    private List<JugadorBase> jugadores;

    @ManyToMany
    @JoinTable(
            name = "pacto_paises",
            joinColumns = @JoinColumn(name = "pacto_id"),
            inverseJoinColumns = @JoinColumn(name = "pais_id")
    )
    private List<Pais> paises;

    private boolean activo;

    @Column(name = "fecha_hora_pacto", nullable = false)
    private LocalDateTime fechaHora;

    public void romperPacto() {
        this.activo = false;
    }

    public boolean estaActivo() {
        return activo;
    }
}
