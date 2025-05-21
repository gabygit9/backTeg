package ar.edu.utn.frc.tup.piii.model.repository;

import ar.edu.utn.frc.tup.piii.model.entities.Canje;
import ar.edu.utn.frc.tup.piii.model.entities.JugadorBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para gestionar operaciones CRUD sobre Canje.
 * {@code @author:} GabrielaCamacho
 */
@Repository
public interface CanjeRepository extends JpaRepository<Canje, Integer> {
}
