package ar.edu.utn.frc.tup.piii.model.repository;

import ar.edu.utn.frc.tup.piii.model.entities.JugadorBase;
import ar.edu.utn.frc.tup.piii.model.entities.PaisPartida;
import ar.edu.utn.frc.tup.piii.model.entities.PaisPartidaId;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio JPA para el estado de cada país dentro de una partida.
 * {@code @author:} GabrielaCamacho
 */
@Repository
public interface PaisPartidaRepository extends JpaRepository<PaisPartida, PaisPartidaId> {
    List<PaisPartida> findByJugador(JugadorBase jugador);
    List<PaisPartida> findByPartidaAndJugador(Partida partida, JugadorBase jugador);
    List<PaisPartida> findByPartida(Partida partida);

}
