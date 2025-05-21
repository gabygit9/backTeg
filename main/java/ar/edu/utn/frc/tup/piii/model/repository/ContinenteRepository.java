package ar.edu.utn.frc.tup.piii.model.repository;

import ar.edu.utn.frc.tup.piii.model.entities.Continente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para los continentes del juego.
 * {@code @author:} GabrielaCamacho
 */
@Repository
public interface ContinenteRepository extends JpaRepository<Continente, Integer> {
}