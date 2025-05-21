package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.model.entities.Usuario;

import java.util.List;

/**
 * Interfaz que define las operaciones relacionadas con la gestión de usuarios.
 * Un usuario puede iniciar sesión, registrarse, o actualizar su perfil.
 *
 * @author Ismael Ceballos
 */
public interface UsuarioService {

    boolean save(Usuario usuario);

    boolean update(Usuario usuario);

    Usuario findById(int id);

    List<Usuario> findAll();

}
