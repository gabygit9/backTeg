package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.model.entities.JugadorBase;
import ar.edu.utn.frc.tup.piii.model.entities.Pacto;
import ar.edu.utn.frc.tup.piii.model.entities.Pais;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;
import ar.edu.utn.frc.tup.piii.model.repository.PactoRepository;
import ar.edu.utn.frc.tup.piii.services.PactoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación de la lógica para gestionar pactos en la partida.
 *
 * Permite a los jugadores firmar pactos, consultar acuerdos activos
 * y validar si se violó alguna alianza.
 *
 * @see Pacto
 * @see Partida
 * @see JugadorBase
 */
@Service
@RequiredArgsConstructor
public class PactoServiceImpl implements PactoService {

    private final PactoRepository pactoRepo;

    @Override
    public boolean save(Pacto pacto){
        Pacto pactoSave = pactoRepo.save(pacto);
        return pactoSave.getId() > 0;
    }

    @Override
    public boolean update(Pacto pacto) {
        if (pactoRepo.existsById(pacto.getId())) {
            pactoRepo.save(pacto);
            return true;
        }
        return false;
    }

    @Override
    public Pacto findById(int id) {
        return pactoRepo.findById(id).orElse(null);
    }

    @Override
    public List<Pacto> findAll() {
        return pactoRepo.findAll();
    }

    @Override
    public Pacto crearPacto(Pacto pacto) {
        return null;
    }

    @Override
    public boolean romperPacto(int pactoId) {
        return false;
    }

    @Override
    public List<Pacto> obtenerPactosPorPartida(int partidaId) {
        return List.of();
    }

}