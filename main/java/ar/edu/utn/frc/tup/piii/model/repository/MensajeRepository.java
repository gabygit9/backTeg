package ar.edu.utn.frc.tup.piii.model.repository;

import ar.edu.utn.frc.tup.piii.model.entities.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para los mensajes enviados en la partida.
 * {@code @author:} GabrielaCamacho
 */
@Repository
public interface MensajeRepository extends JpaRepository<Mensaje, Integer> {
}
