package ar.edu.utn.frc.tup.piii.model.repository;

import ar.edu.utn.frc.tup.piii.model.entities.HistorialEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para eventos del historial de la partida.
 * {@code @author:} GabrielaCamacho
 */
@Repository
public interface HistorialRepository extends JpaRepository<HistorialEvento, Integer> {
}
