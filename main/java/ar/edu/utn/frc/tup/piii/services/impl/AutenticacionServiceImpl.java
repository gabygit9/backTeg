package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.model.repository.UsuarioRepository;
import ar.edu.utn.frc.tup.piii.services.AutenticacionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Implementación del servicio de autenticación.
 * Maneja el inicio de sesión, registro y validación de credenciales.
 *
 *  @author GabrielaCamacho
 *  @version 1.0
 */
@Service
@RequiredArgsConstructor
public class AutenticacionServiceImpl implements AutenticacionService {
    private final UsuarioRepository usuarioRepository;

    /**
     * Inicia sesión de un usuario validando sus credenciales.
     *
     * @param email Email ingresado.
     * @param password Contraseña ingresada.
     * @return Token o mensaje simulado. (En implementación real, se genera JWT o similar)
     */
    @Override
    public String login(String email, String password) {
        return "";
    }

    /**
     * Registra un nuevo usuario codificando su contraseña y guardándolo en la base de datos.
     *
     * @param email Email del nuevo usuario.
     * @param password Contraseña en texto plano.
     * @param nombre Nombre del usuario.
     */
    @Override
    public void registrar(String email, String password, String nombre) {

    }
    /**
     * Verifica si ya existe un usuario con ese email.
     *
     * @param email Email a buscar.
     * @return true si existe, false si está disponible.
     */
    @Override
    public boolean existeEmail(String email) {
        return false;
    }
}
