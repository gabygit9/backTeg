package ar.edu.utn.frc.tup.piii.controllers;

//TODO agregar manejo de excepciones y respuestas HTTP más detalladas
//TODO usar responseEntity<?> en la firma de todos los métodos

import ar.edu.utn.frc.tup.piii.model.entities.Usuario;
import ar.edu.utn.frc.tup.piii.services.AutenticacionService;
import ar.edu.utn.frc.tup.piii.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para la gestión de usuarios y autenticación.
 * Proporciona endpoints para registrar, autenticar, y administrar usuarios.
 *
 * @author GabrielaCamacho
 * @version 1.0
 *
 * @see UsuarioService
 * @see AutenticacionService
 */
@RestController
@RequestMapping("/api/v1/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService usuarioService;
    private final AutenticacionService autenticacionService;

    /**
     * Registra un nuevo usuario.
     *
     * @param email Email del nuevo usuario.
     * @param password Contraseña.
     * @param nombre Nombre del usuario.
     * @return Respuesta 200 si se registró exitosamente.
     */
    @PostMapping("/registrar")
    public ResponseEntity<Void> registrar(
            @RequestParam String email,
            @RequestParam String password,
            @RequestParam String nombre) {
        autenticacionService.registrar(email, password, nombre);
        return ResponseEntity.ok().build();
    }

    /**
     * Autentica a un usuario con email y contraseña.
     *
     * @param email Email del usuario.
     * @param password Contraseña del usuario.
     * @return Token o mensaje de sesión.
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(
            @RequestParam String email,
            @RequestParam String password) {
        String token = autenticacionService.login(email, password);
        return ResponseEntity.ok(token);
    }

    /**
     * Verifica si un email ya está registrado.
     *
     * @param email Email a verificar.
     * @return true si el email ya existe, false si está disponible.
     */
    @GetMapping("/existe")
    public ResponseEntity<Boolean> existeEmail(@RequestParam String email) {
        return ResponseEntity.ok(autenticacionService.existeEmail(email));
    }

    /**
     * Retorna todos los usuarios registrados.
     *
     * @return Lista de usuarios.
     */
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    /**
     * Obtiene un usuario por su ID.
     *
     * @param id ID del usuario.
     * @return Usuario correspondiente o 404 si no existe.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable int id) {
        Usuario usuario = usuarioService.findById(id);
        return usuario != null ? ResponseEntity.ok(usuario) : ResponseEntity.notFound().build();
    }

    /**
     * Actualiza los datos de un usuario existente.
     *
     * @param usuario Objeto usuario con los nuevos datos.
     * @return true si se actualizó correctamente.
     */
    @PutMapping
    public ResponseEntity<Boolean> updateUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.update(usuario));
    }

    /**
     * Guarda un nuevo usuario desde un objeto.
     *
     * @param usuario Usuario a guardar.
     * @return true si se guardó correctamente.
     */
    @PostMapping
    public ResponseEntity<Boolean> saveUsuario(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.save(usuario));
    }
}
