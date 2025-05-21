package ar.edu.utn.frc.tup.piii.model.repository;

import ar.edu.utn.frc.tup.piii.model.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para usuarios
 * {@code @author:} GabrielaCamacho
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
