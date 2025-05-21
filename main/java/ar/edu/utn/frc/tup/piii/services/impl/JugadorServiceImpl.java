package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.model.entities.*;
import ar.edu.utn.frc.tup.piii.model.repository.JugadorRepository;
import ar.edu.utn.frc.tup.piii.services.JugadorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Esta clase es un servicio del repositorio de JugadorBase, donde se podrá acceder
 * a sus clases hijas (JugadorHumano, jugadorBotNovato, jugadorBotBalanceado, jugadorBotExperto)
 * {@code @author:} Ismael Ceballos
 * @see JugadorBase
 * @see JugadorPartida
 * @see Partida
 *
 * @author Ismael Ceballos
 */
@Service
@RequiredArgsConstructor
public class JugadorServiceImpl implements JugadorService {

    private final JugadorRepository jugadorRepo;

    @Override
    public JugadorBase findById(int id) {
        return jugadorRepo.findById(id).orElse(null);
    }

    @Override
    public List<JugadorBase> findAll() {
        return jugadorRepo.findAll();
    }

    @Override
    public boolean save(JugadorBase jugador){
        JugadorBase pactoSave = jugadorRepo.save(jugador);
        return pactoSave.getId() > 0;
    }

    @Override
    public boolean update(JugadorBase jugador) {
        if (jugadorRepo.existsById(jugador.getId())) {
            jugadorRepo.save(jugador);
            return true;
        }
        return false;
    }

    @Override
    public JugadorPartida registrarJugadorEnPartida(JugadorBase jugador, int partidaId, int ordenTurno) {
        return null;
    }

    @Override
    public List<JugadorPartida> obtenerJugadoresDePartida(Partida partida) {
        return List.of();
    }

    @Override
    public boolean cumplioObjetivo(int jugadorPartida) {
        return false;
    }

}