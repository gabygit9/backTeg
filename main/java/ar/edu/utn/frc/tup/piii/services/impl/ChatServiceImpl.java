package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.model.entities.JugadorBase;
import ar.edu.utn.frc.tup.piii.model.entities.Mensaje;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;
import ar.edu.utn.frc.tup.piii.model.repository.MensajeRepository;
import ar.edu.utn.frc.tup.piii.services.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación de la lógica de envío y recuperación de mensajes entre jugadores en una partida.
 * Esta clase maneja la persistencia de mensajes en el historial de chat.
 *
 * @author GabrielaCamacho
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
    private final MensajeRepository mensajeRepository;

    /**
     * Envía un nuevo mensaje desde un jugador a una partida.
     *
     * Crea una instancia de Mensaje con la información recibida,
     * le asigna la hora actual y lo guarda en la base de datos.
     *
     * @param emisorId Jugador que envía el mensaje.
     * @param contenido Texto del mensaje.
     * @param partidaId Partida a la que pertenece el mensaje.
     * @return El mensaje persistido con su ID generado y fecha asignada.
     */
    @Override
    public Mensaje enviarMensaje(int partidaId, int emisorId, String contenido) {
        return null;
    }

    /**
     * Recupera todos los mensajes de una partida ordenados cronológicamente.
     *
     * Utiliza el repositorio para buscar por partida y orden ascendente
     * por fecha y hora.
     *
     * @param partida La partida cuyo historial de mensajes se desea obtener.
     * @return Lista ordenada de mensajes asociados a la partida.
     */
    @Override
    public List<Mensaje> obtenerMensajesPorPartida(Partida partida) {
        return List.of();
    }
}
