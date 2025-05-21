package ar.edu.utn.frc.tup.piii.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Representa un usuario registrado en la plataforma.
 *  El usuario puede jugar partidas, y se le asigna un rol para determinar sus permisos.
 *
 * @author GabrielaCamacho
 * @version 1.0
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    private String email;

    private String password;

    @ManyToOne
    @JoinColumn(name = "usuario_rol_id", nullable = false)
    private Rol rol;
}
