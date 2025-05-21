package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.model.entities.HistorialEvento;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;
import ar.edu.utn.frc.tup.piii.model.repository.HistorialRepository;
import ar.edu.utn.frc.tup.piii.services.HistorialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Implementación del servicio que gestiona el historial de eventos del juego.
 *
 * Este servicio registra cada acción relevante que ocurre durante una partida
 * (ataques, conquistas, canjes, cumplimiento de objetivos, etc.),
 * permitiendo luego su consulta para revisión o trazabilidad.
 *
 * @see HistorialEvento
 * @see Partida
 * @author Grupo 7
 */
@Service
@RequiredArgsConstructor
public class HistorialServiceImpl implements HistorialService {

    private final HistorialRepository historialRepo;

    @Override
    public boolean save(HistorialEvento historial){
        HistorialEvento historialSave = historialRepo.save(historial);
        return historialSave.getId() > 0;
    }

    @Override
    public boolean update(HistorialEvento historial) {
        if (historialRepo.existsById(historial.getId())) {
            historialRepo.save(historial);
            return true;
        }
        return false;
    }

    @Override
    public HistorialEvento findById(int id) {
        return historialRepo.findById(id).orElse(null);
    }

    @Override
    public List<HistorialEvento> findAll() {
        return historialRepo.findAll();
    }

    @Override
    public HistorialEvento registrarEvento(Partida partida, String descripcion, LocalDateTime fechaHora) {
        return null;
    }

    @Override
    public List<HistorialEvento> obtenerEventosPorPartida(Partida partida) {
        return List.of();
    }

}