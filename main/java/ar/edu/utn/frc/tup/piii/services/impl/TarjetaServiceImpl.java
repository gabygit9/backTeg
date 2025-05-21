package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.model.entities.TarjetaJugador;
import ar.edu.utn.frc.tup.piii.model.entities.TarjetaPais;
import ar.edu.utn.frc.tup.piii.model.repository.TarjetaJugadorRepository;
import ar.edu.utn.frc.tup.piii.model.repository.TarjetaPaisRepository;
import ar.edu.utn.frc.tup.piii.services.TarjetaService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio de tarjetas.
 * Gestiona el reparto, uso y validación de tarjetas dentro de una partida.
 */
@Service
public class TarjetaServiceImpl implements TarjetaService {

    private final TarjetaPaisRepository tPaisRepo;

    private final TarjetaJugadorRepository tJugadorRepo;

    public TarjetaServiceImpl(TarjetaPaisRepository tPaisRepo, TarjetaJugadorRepository tJugadorRepo) {
        this.tPaisRepo = tPaisRepo;
        this.tJugadorRepo = tJugadorRepo;
    }

    // Repo de TarjetaPais

    @Override
    public boolean savePais(TarjetaPais tarjeta){
        TarjetaPais paisSave = tPaisRepo.save(tarjeta);
        return paisSave.getId() > 0;
    }

    @Override
    public boolean updatePais(TarjetaPais tarjeta) {
        if (tPaisRepo.existsById(tarjeta.getId())) {
            tPaisRepo.save(tarjeta);
            return true;
        }
        return false;
    }

    @Override
    public TarjetaPais findByIdPais(int id) {
        return tPaisRepo.findById(id).orElse(null);
    }

    @Override
    public List<TarjetaPais> findAllPais() {
        return tPaisRepo.findAll();
    }

    // Repo de TarjetaJugador

    @Override
    public boolean saveJugador(TarjetaJugador tarjeta){
        TarjetaJugador jugadorSave = tJugadorRepo.save(tarjeta);
        return jugadorSave.getId() > 0;
    }

    @Override
    public boolean updateJugador(TarjetaJugador tarjeta) {
        if (tJugadorRepo.existsById(tarjeta.getId())) {
            tJugadorRepo.save(tarjeta);
            return true;
        }
        return false;
    }

    @Override
    public TarjetaJugador findByIdJugador(int id) {
        return tJugadorRepo.findById(id).orElse(null);
    }

    @Override
    public List<TarjetaJugador> findAllJugador() {
        return tJugadorRepo.findAll();
    }

    @Override
    public TarjetaPais obtenerTarjetaDisponible() {
        return null;
    }

    @Override
    public TarjetaPais asignarTarjetaAJugador(int tarjetaId, int jugadorPartidaId) {

        return null;
    }

    @Override
    public void marcarTarjetaComoUsada(int tarjetaJugadorId) {

    }

    @Override
    public List<TarjetaJugador> obtenerTarjetasDeJugador(int jugadorPartidaId) {
        return List.of();
    }

    @Override
    public boolean esCanjeValido(List<Integer> tarjetasIds, int jugadorPartidaId) {
        return false;
    }

}
