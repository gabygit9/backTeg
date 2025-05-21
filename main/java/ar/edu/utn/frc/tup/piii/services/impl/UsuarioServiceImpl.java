package ar.edu.utn.frc.tup.piii.services.impl;

import ar.edu.utn.frc.tup.piii.model.entities.Usuario;
import ar.edu.utn.frc.tup.piii.model.repository.UsuarioRepository;
import ar.edu.utn.frc.tup.piii.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio de usuarios.
 * Gestiona el registro, recuperación y administración de usuarios.
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepo;

    public UsuarioServiceImpl(UsuarioRepository repo) {
        this.usuarioRepo = repo;
    }

    @Override
    public boolean save(Usuario usuario){
        Usuario usuarioSave = usuarioRepo.save(usuario);
        return usuarioSave.getId() > 0;
    }

    @Override
    public boolean update(Usuario usuario) {
        if (usuarioRepo.existsById(usuario.getId())) {
            usuarioRepo.save(usuario);
            return true;
        }
        return false;
    }

    @Override
    public Usuario findById(int id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> findAll() {
        return usuarioRepo.findAll();
    }

}
