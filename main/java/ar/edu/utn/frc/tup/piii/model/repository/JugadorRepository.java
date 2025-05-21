package ar.edu.utn.frc.tup.piii.model.repository;

import ar.edu.utn.frc.tup.piii.model.entities.JugadorBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Esta interfaz es el repositorio de la clase Jugador, es donde se hacen las consultas a la tabla jugador en la BD.
 * {@code @author:} Ismael Ceballos
 * @see JugadorBase
 */
@Repository
public interface JugadorRepository extends JpaRepository<JugadorBase, Integer> {
}
