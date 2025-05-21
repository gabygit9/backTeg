package ar.edu.utn.frc.tup.piii.services;

/**
 * Servicio de autenticación del sistema.
 * Define las operaciones relacionadas con el inicio de sesión, registro y validación de usuarios.
 *
 * @author GabrielaCamacho
 * @version 1.0
 */
public interface AutenticacionService {

    /**
     * Inicia sesión de un usuario con su email y contraseña.
     *
     * @param email Email del usuario.
     * @param password Contraseña del usuario.
     * @return Token de sesión o información de acceso si las credenciales son válidas.
     */
    String login(String email, String password);

    /**
     * Registra un nuevo usuario en el sistema.
     *
     * @param email Email del nuevo usuario.
     * @param password Contraseña del nuevo usuario.
     * @param nombre Nombre del usuario.
     */
    void registrar(String email, String password, String nombre);

    /**
     * Verifica si un email ya está registrado en el sistema.
     *
     * @param email Email a verificar.
     * @return true si ya existe, false si está disponible.
     */
    boolean existeEmail(String email);
}
