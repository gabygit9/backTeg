package ar.edu.utn.frc.tup.piii.model.repository;

import ar.edu.utn.frc.tup.piii.model.entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para partidas del juego.
 * {@code @author:} GabrielaCamacho
 */
@Repository
public interface PartidaRepository extends JpaRepository<Partida, Integer> {
}
