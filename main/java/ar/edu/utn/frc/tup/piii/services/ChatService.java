package ar.edu.utn.frc.tup.piii.services;

import ar.edu.utn.frc.tup.piii.model.entities.JugadorBase;
import ar.edu.utn.frc.tup.piii.model.entities.Mensaje;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;

import java.util.List;

public interface ChatService {
    /**
     * Enviar un mensaje en una partida.
     *
     * @param emisorId Jugador que envía el mensaje.
     * @param contenido Texto del mensaje.
     * @param partidaId Partida en la que se envía.
     * @return Mensaje creado y guardado.
     */
    Mensaje enviarMensaje(int partidaId, int emisorId, String contenido);

    /**
     * Obtener todos los mensajes de una partida.
     *
     * @param partida Partida de la que se desea obtener los mensajes.
     * @return Lista de mensajes ordenados cronológicamente.
     */
    List<Mensaje> obtenerMensajesPorPartida(Partida partida);
}
