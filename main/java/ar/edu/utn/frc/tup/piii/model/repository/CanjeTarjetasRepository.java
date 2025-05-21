package ar.edu.utn.frc.tup.piii.model.repository;

import ar.edu.utn.frc.tup.piii.model.entities.CanjeTarjetas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la asociación entre Canjes y Tarjetas.
 * {@code @author:} GabrielaCamacho
 */
@Repository
public interface CanjeTarjetasRepository extends JpaRepository<CanjeTarjetas, Integer> {
}
