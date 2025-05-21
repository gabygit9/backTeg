package ar.edu.utn.frc.tup.piii.model.repository;

import ar.edu.utn.frc.tup.piii.model.entities.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para países.
 * {@code @author:} GabrielaCamacho
 */
@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {
}
