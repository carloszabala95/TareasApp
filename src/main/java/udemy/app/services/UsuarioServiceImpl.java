package udemy.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.app.persistence.entities.Usuario;
import udemy.app.persistence.repositories.TareaRepository;
import udemy.app.persistence.repositories.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TareaService tareaService;

    @Override
    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuario(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public Usuario updateUsuario(Usuario usuario) {
        Usuario user = usuarioRepository.findByUsername(usuario.getUsername());
        if (user != null) { //Si hay un user existente, actualizamos sus datos de nombre y password
            user.setNombre(usuario.getNombre());
            user.setPassword(usuario.getPassword());
            return usuarioRepository.save(user);
        }else{
            return null;
        }
    }

    @Override
    public Usuario deleteUsuario(String username) {
        Usuario user = usuarioRepository.findByUsername(username);
        tareaService.deleteByUsuarioId(user.getId());
        usuarioRepository.delete(user);
        return user;
    }


}
