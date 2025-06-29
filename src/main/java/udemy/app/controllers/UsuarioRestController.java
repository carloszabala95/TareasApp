package udemy.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udemy.app.persistence.entities.Usuario;
import udemy.app.services.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    private ResponseEntity<?> getUsuarios() {
        List<Usuario> usuarios = usuarioService.getUsuarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{username}")
    private ResponseEntity<?> getUsuario(@PathVariable("username") String username) {
        return ResponseEntity.ok(usuarioService.getUsuario(username));
    }

    @PutMapping
    private ResponseEntity<?> updateUsuario(@RequestBody Usuario usuario) {
        // Assuming there's an update method in the service
        return ResponseEntity.ok(usuarioService.updateUsuario(usuario));
    }

    @DeleteMapping("/{username}")
    private ResponseEntity<?> deleteUsuario(@PathVariable("username") String username) {
        return ResponseEntity.ok(usuarioService.deleteUsuario(username));
    }

}
