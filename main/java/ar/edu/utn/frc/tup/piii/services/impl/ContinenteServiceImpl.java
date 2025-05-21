package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.model.entities.Continente;
import ar.edu.utn.frc.tup.piii.model.repository.ContinenteRepository;
import ar.edu.utn.frc.tup.piii.services.ContinenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ContinenteServiceImpl implements ContinenteService {

    private final ContinenteRepository continenteRepository;

    @Override
    public List<Continente> obtenerTodos() {
        return continenteRepository.findAll();
    }

    @Override
    public Continente obtenerPorId(int id) {
        return continenteRepository.findById(id).orElse(null);
    }
}
