package ar.edu.utn.frc.tup.piii.model.repository;

import ar.edu.utn.frc.tup.piii.model.entities.ConexionPais;
import ar.edu.utn.frc.tup.piii.model.entities.ConexionPaisId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para conexiones entre países (fronteras).
 * {@code @author:} GabrielaCamacho
 */
@Repository
public interface ConexionPaisRepository extends JpaRepository<ConexionPais, ConexionPaisId> {
}
