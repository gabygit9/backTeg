package ar.edu.utn.frc.tup.piii.model.repository;

import ar.edu.utn.frc.tup.piii.model.entities.Objetivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para los objetivos del juego.
 * {@code @author:} GabrielaCamacho
 */
@Repository
public interface ObjetivoRepository extends JpaRepository<Objetivo, Integer> {
}
