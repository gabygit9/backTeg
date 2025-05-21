package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.model.entities.CanjeTarjetas;
import ar.edu.utn.frc.tup.piii.model.repository.CanjeTarjetasRepository;
import ar.edu.utn.frc.tup.piii.services.CanjeTarjetasService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Implementación del servicio que gestiona el proceso de canje de tarjetas por ejércitos.
 *
 * @author Ismael Ceballos
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class CanjeTarjetasServiceImpl implements CanjeTarjetasService {

    private final CanjeTarjetasRepository canjeTarjetasRepo;

    @Override
    public boolean save(CanjeTarjetas canjeTarjetas){
        CanjeTarjetas CTSave = canjeTarjetasRepo.save(canjeTarjetas);
        return CTSave.getId() > 0;
    }

    @Override
    public boolean update(CanjeTarjetas canjeTarjetas) {
        if (canjeTarjetasRepo.existsById(canjeTarjetas.getId())) {
            canjeTarjetasRepo.save(canjeTarjetas);
            return true;
        }
        return false;
    }

    @Override
    public CanjeTarjetas findById(int id) {
        return canjeTarjetasRepo.findById(id).orElse(null);
    }

    @Override
    public List<CanjeTarjetas> findAll() {
        return canjeTarjetasRepo.findAll();
    }

    /**
     * Realiza un canje de tarjetas por ejércitos.
     *
     * @param jugadorPartidaId ID del jugador en la partida.
     */
    @Override
    public void realizarCanje(int jugadorPartidaId) {

    }

    /**
     * Verifica si el jugador puede realizar un canje de tarjetas.
     *
     * @param jugadorPartidaId ID del jugador en la partida.
     * @return true si tiene una combinación válida, false si no.
     */
    @Override
    public boolean puedeCanjear(int jugadorPartidaId) {
        return false;
    }

    /**
     * Retorna la cantidad de ejércitos por el próximo canje disponible.
     *
     * @param jugadorPartidaId ID del jugador en la partida.
     * @return cantidad de ejércitos.
     */
    @Override
    public int obtenerEjercitosPorProximoCanje(int jugadorPartidaId) {
        return 0;
    }

}
