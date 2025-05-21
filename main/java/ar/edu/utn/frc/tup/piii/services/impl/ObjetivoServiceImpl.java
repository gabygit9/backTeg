package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.model.entities.JugadorPartida;
import ar.edu.utn.frc.tup.piii.model.entities.Objetivo;
import ar.edu.utn.frc.tup.piii.model.repository.ObjetivoRepository;
import ar.edu.utn.frc.tup.piii.services.ObjetivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio para gestión de objetivos del juego.
 *
 * Permite asignar objetivos a los jugadores y verificar si los han cumplido,
 * según las reglas de victoria del juego.
 *
 * @author Ismael Ceballos
 *
 * @see Objetivo
 * @see JugadorPartida
 * @see ObjetivoRepository
 */
@Service
@RequiredArgsConstructor
public class ObjetivoServiceImpl implements ObjetivoService {

    private final ObjetivoRepository objetivoRepo;

    @Override
    public Objetivo findById(int id) {
        return objetivoRepo.findById(id).orElse(null);
    }

    @Override
    public List<Objetivo> findAll() {
        return objetivoRepo.findAll();
    }

    @Override
    public Objetivo save(Objetivo objetivo) {
        return objetivoRepo.save(objetivo);
    }

    @Override
    public Objetivo update(Objetivo objetivo) {
        if(objetivoRepo.existsById(objetivo.getId())){
            return objetivoRepo.save(objetivo);
        }
        return null;
    }

    @Override
    public void delete(int id) {
        if(objetivoRepo.existsById(id)){
            objetivoRepo.deleteById(id);
        }
    }


}
