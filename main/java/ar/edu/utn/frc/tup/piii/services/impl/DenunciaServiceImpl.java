package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.model.entities.Denuncia;
import ar.edu.utn.frc.tup.piii.model.entities.JugadorBase;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;
import ar.edu.utn.frc.tup.piii.model.entities.TipoComunicacion;
import ar.edu.utn.frc.tup.piii.model.repository.DenunciaRepository;
import ar.edu.utn.frc.tup.piii.services.DenunciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio de denuncias.
 *
 * Se encarga de persistir y recuperar denuncias realizadas por jugadores dentro de una partida.
 * Utiliza el repositorio de Denuncia para interactuar con la base de datos.
 *
 * Este servicio apoya el sistema de control de comunicación, permitiendo registrar
 * y revisar reclamos contra jugadores que hayan incumplido el tipo de comunicación establecido.
 *
 * @see Denuncia
 * @see DenunciaRepository
 * @see TipoComunicacion
 *
 * @author Ismael Ceballos
 */
@Service
@RequiredArgsConstructor
public class DenunciaServiceImpl implements DenunciaService {

    private final DenunciaRepository denunciaRepo;

    @Override
    public boolean save(Denuncia denuncia){
        Denuncia denunciaSave = denunciaRepo.save(denuncia);
        return denunciaSave.getId() > 0;
    }

    @Override
    public boolean update(Denuncia denuncia) {
        if (denunciaRepo.existsById(denuncia.getId())) {
            denunciaRepo.save(denuncia);
            return true;
        }
        return false;
    }

    @Override
    public Denuncia findById(int id) {
        return denunciaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Denuncia> findAll() {
        return denunciaRepo.findAll();
    }

    @Override
    public Denuncia registrarDenuncia(Partida partida, JugadorBase acusador, JugadorBase acusado, String motivo) {
        return null;
    }

    @Override
    public List<Denuncia> obtenerDenunciasPorPartida(Partida partida) {
        return List.of();
    }

}
