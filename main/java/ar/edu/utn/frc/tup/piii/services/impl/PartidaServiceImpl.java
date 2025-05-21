package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.model.entities.Pacto;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;
import ar.edu.utn.frc.tup.piii.model.repository.JugadorPartidaRepository;
import ar.edu.utn.frc.tup.piii.model.repository.PactoRepository;
import ar.edu.utn.frc.tup.piii.model.repository.PaisPartidaRepository;
import ar.edu.utn.frc.tup.piii.model.repository.PartidaRepository;
import ar.edu.utn.frc.tup.piii.services.PartidaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio que gestiona el ciclo de vida y reglas de una partida.
 * Contiene la lógica central de control del flujo del juego.
 */
@Service
@RequiredArgsConstructor
public class PartidaServiceImpl implements PartidaService {

    private final PartidaRepository partidaRepo;
    private final JugadorPartidaRepository jugadorPartidaRepository;
    private final PactoRepository pactoRepository;
    private final PaisPartidaRepository paisPartidaRepository;


    @Override
    public boolean save(Partida partida){
        Partida partidaSave = partidaRepo.save(partida);
        return partidaSave.getId() > 0;
    }

    @Override
    public boolean update(Partida partida) {
        if (partidaRepo.existsById(partida.getId())) {
            partidaRepo.save(partida);
            return true;
        }
        return false;
    }

    @Override
    public Partida findById(int id) {
        return partidaRepo.findById(id).orElse(null);
    }

    @Override
    public List<Partida> findAll() {
        return partidaRepo.findAll();
    }

    @Override
    public boolean iniciarPartida(Partida partidaId) {
        return false;
    }

    @Override
    public boolean continuarPartida(int partidaId) {
        return false;
    }

    @Override
    public boolean finalizarPartida(int partidaId) {
        return false;
    }

    @Override
    public void iniciarHostilidades(int partidaId) {

    }

    @Override
    public void repartirTarjetas(int partidaId) {

    }

    @Override
    public boolean registrarJugador(int partidaId, int jugadorId) {
        return false;
    }

    @Override
    public List<Integer> tirarDados(int atacanteId, int defensorId) {
        return List.of();
    }

    @Override
    public boolean esLimitrofe(int paisId1, int paisId2) {
        return false;
    }

    @Override
    public void anunciarAtaque(int origenId, int destinoId) {

    }

    @Override
    public void retirarEjercito(int paisId, int cantidad) {

    }

    @Override
    public void conquistarPais(int paisId, int jugadorId) {

    }

    @Override
    public void incorporarEjercito(int jugadorPartidaId) {

    }

    @Override
    public List<String> continenteOcupado(int jugadorPartidaId) {
        return List.of();
    }

    @Override
    public List<Pacto> verPactos(int partidaId) {
        return List.of();
    }

    @Override
    public String estiloComunicacion(int partidaId) {
        return "";
    }

    @Override
    public void guardarEstado(int partidaId) {

    }

    @Override
    public Partida cargarEstado(int partidaId) {

        return null;
    }

    @Override
    public void asignarObjetivosSecretos(int partidaId) {

    }

    @Override
    public void asignarObjetivoComun(int partidaId, int objetivoComunId) {

    }

}
