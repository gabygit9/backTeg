package ar.edu.utn.frc.tup.piii.dto;

import lombok.Data;

/**
 * DTO para enviar un mensaje en el chat.
 *
 * @author GabrielaCamacho
 */
@Data
public class MensajeRequestdto {
    private int partidaId;
    private int emisorId;
    private String contenido;
}
