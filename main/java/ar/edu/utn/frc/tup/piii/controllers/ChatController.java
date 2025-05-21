package ar.edu.utn.frc.tup.piii.controllers;


import ar.edu.utn.frc.tup.piii.dto.MensajeRequestdto;
import ar.edu.utn.frc.tup.piii.model.entities.Mensaje;
import ar.edu.utn.frc.tup.piii.model.entities.Partida;
import ar.edu.utn.frc.tup.piii.services.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


//TODO agregar manejo de excepciones y respuestas HTTP más detalladas
//TODO usar responseEntity<?> en la firma de todos los métodos
/**
 * Controlador para gestionar los mensajes de chat dentro de una partida.
 * Permite enviar y obtener mensajes, y está vinculado al sistema de comunicación.
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see Mensaje
 * @see ChatService
 */
@RestController
@RequestMapping("/api/v1/chat")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    /**
     * Obtiene todos los mensajes de una partida específica.
     *
     * @param partidaId ID de la partida
     * @return lista de mensajes
     */
    @GetMapping("/{partidaId}/mensajes")
    public List<Mensaje> obtenerMensajesDePartida(@PathVariable Partida partidaId) {
        return chatService.obtenerMensajesPorPartida(partidaId);
    }

    /**
     * Permite enviar un nuevo mensaje en una partida.
     *
     * @param request objeto mensaje con contenido, emisor y partida
     * @return mensaje guardado
     */
    @PostMapping("/enviar")
    public Mensaje enviarMensaje(@RequestBody MensajeRequestdto request) {
        return chatService.enviarMensaje(request.getPartidaId(), request.getEmisorId(), request.getContenido());
    }
}
