package ar.edu.utn.frc.tup.piii.model.repository;

import ar.edu.utn.frc.tup.piii.model.entities.TarjetaJugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para tarjetas de jugador.
 * {@code @author:} GabrielaCamacho
 */
@Repository
public interface TarjetaJugadorRepository extends JpaRepository<TarjetaJugador, Integer> {
}
