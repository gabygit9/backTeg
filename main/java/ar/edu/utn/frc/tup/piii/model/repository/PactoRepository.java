package ar.edu.utn.frc.tup.piii.model.repository;

import ar.edu.utn.frc.tup.piii.model.entities.Pacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para pactos entre jugadores
 * {@code @author:} GabrielaCamacho
 */
@Repository
public interface PactoRepository extends JpaRepository<Pacto, Integer> {
}
