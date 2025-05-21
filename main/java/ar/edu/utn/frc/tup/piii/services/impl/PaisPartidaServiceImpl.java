package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.model.entities.JugadorBase;
import ar.edu.utn.frc.tup.piii.model.entities.PaisPartida;
import ar.edu.utn.frc.tup.piii.model.entities.PaisPartidaId;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;
import ar.edu.utn.frc.tup.piii.model.repository.PaisPartidaRepository;
import ar.edu.utn.frc.tup.piii.services.PaisPartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de gestión de países en partidas.
 *
 * Administra la relación dinámica entre países, jugadores y partidas,
 * registrando cantidad de ejércitos y dominio en tiempo real.
 *
 * @author Ismael Ceballos
 */
@Service
@RequiredArgsConstructor
public class PaisPartidaServiceImpl implements PaisPartidaService {

    private final PaisPartidaRepository PPRepo;

    @Override
    public boolean save(PaisPartida paisPartida){
        PaisPartida paisPartidaSave = PPRepo.save(paisPartida);
        return paisPartidaSave != null;
    }

    @Override
    public boolean update(PaisPartida paisPartida) {
        if (PPRepo.existsById(paisPartida.getId())) {
            PPRepo.save(paisPartida);
            return true;
        }
        return false;
    }

    //No aplica ya que el id es compuesto
    @Override
    public PaisPartida findById(int id) {throw new UnsupportedOperationException("Usar findById(PaisPartidaId id)");}

    @Override
    public List<PaisPartida> findAll() {
        return PPRepo.findAll();
    }

    /**
     * Busca una relación por ID compuesto.
     *
     * @param id ID compuesto de partida y país
     * @return entidad si existe, o null si no.
     */
    public PaisPartida findById(PaisPartidaId id) {
        Optional<PaisPartida> result = PPRepo.findById(id);
        return result.orElse(null);
    }

    @Override
    public List<PaisPartida> findByJugador(JugadorBase jugador) {
        return PPRepo.findByJugador(jugador);
    }

    @Override
    public List<PaisPartida> findByPartidaAndJugador(Partida partida, JugadorBase jugador) {
        return PPRepo.findByPartidaAndJugador(partida, jugador);
    }

    @Override
    public List<PaisPartida> findByPartida(Partida partida) {
        return PPRepo.findByPartida(partida);
    }

    @Override
    public void aumentarEjercitos(PaisPartidaId id, int cantidad) {
        PaisPartida paisPartida = PPRepo.findById(id).orElse(null);
        if (paisPartida != null) {
            paisPartida.setCantidadEjercitos(paisPartida.getCantidadEjercitos() + cantidad);
            PPRepo.save(paisPartida);
        }
    }
}
