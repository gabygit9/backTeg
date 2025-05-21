package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.model.entities.JugadorPartida;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;
import ar.edu.utn.frc.tup.piii.model.entities.Turno;
import ar.edu.utn.frc.tup.piii.model.repository.TurnoRepository;
import ar.edu.utn.frc.tup.piii.services.TurnoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio de turnos.
 * Controla el flujo de turnos dentro de una partida, administrando fases y orden de jugadores.
 */
@Service
public class TurnoServiceImpl implements TurnoService {

    private final TurnoRepository turnoRepo;

    public TurnoServiceImpl(TurnoRepository turnoRepo) {
        this.turnoRepo = turnoRepo;
    }

    @Override
    public boolean save(Turno turno){
        Turno turnoSave = turnoRepo.save(turno);
        return turnoSave.getId() > 0;
    }

    @Override
    public boolean update(Turno turno) {
        if (turnoRepo.existsById(turno.getId())) {
            turnoRepo.save(turno);
            return true;
        }
        return false;
    }

    @Override
    public Turno findById(int id) {
        return turnoRepo.findById(id).orElse(null);
    }

    @Override
    public List<Turno> findAll() {
        return turnoRepo.findAll();
    }

    @Override
    public void iniciarTurno(JugadorPartida jugadorPartida, Partida partida) {

    }

    @Override
    public void pasarFase(Turno turno) {

    }

    @Override
    public List<String> obtenerAccionesDisponibles(Turno turno) {
        return List.of();
    }

    @Override
    public void finalizarTurno(Turno turno) {

    }

}
