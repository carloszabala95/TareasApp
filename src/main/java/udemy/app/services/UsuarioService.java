package udemy.app.services;

import udemy.app.persistence.entities.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> getUsuarios();

    Usuario getUsuario(String username);
    Usuario updateUsuario(Usuario usuario);

    Usuario deleteUsuario(String username);

}
