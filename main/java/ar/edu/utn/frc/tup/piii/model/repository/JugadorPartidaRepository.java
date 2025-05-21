package ar.edu.utn.frc.tup.piii.model.repository;

import ar.edu.utn.frc.tup.piii.model.entities.JugadorPartida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la relación jugador-partida
 * {@code @author:} GabrielaCamacho
 */
@Repository
public interface JugadorPartidaRepository extends JpaRepository<JugadorPartida, Integer> {
}
