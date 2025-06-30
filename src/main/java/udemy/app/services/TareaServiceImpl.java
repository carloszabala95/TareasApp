package udemy.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.app.persistence.entities.Tarea;
import udemy.app.persistence.entities.Tipo;
import udemy.app.persistence.entities.Usuario;
import udemy.app.persistence.repositories.TareaRepository;
import udemy.app.persistence.repositories.TipoRepository;
import udemy.app.persistence.repositories.UsuarioRepository;

import java.time.LocalDate;
import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Override
    public List<Tarea> deletetareaByTipoId(int id) {
        List<Tarea> tareas = tareaRepository.findAllByTipo_id(id);
        tareaRepository.deleteAll(tareas);
        return tareas;
    }

    @Override
    public List<Tarea> getTareas(String username) {
        Usuario user = usuarioRepository.findByUsername(username);
        if (user == null) {
            return null; // Si el usuario no existe, devolvemos null
        }else{
            return tareaRepository.findAllByUsuario_id(user.getId());
        }
    }

    @Override
    public Tarea addTarea(String username, String tipo, Tarea tarea) {
        Usuario usuario = usuarioRepository.findByUsername(username);
        if (usuario != null) {
            Tipo t = tipoRepository.findByNombre(tipo);
            if(t != null) {
                tarea.setRealizada(false);
                tarea.setUsuario(usuario);
                tarea.setFecha(LocalDate.now());
                tarea.setTipo(t);
                return tareaRepository.save(tarea); // Guardamos la tarea y devolvemos el objeto guardado
            } else {
                return null; // Si el tipo no existe, devolvemos null
            }
        }else{
            return null;
        }
    }

    @Override
    public Tarea updateTarea(Tarea tarea) {
        Tarea t = tareaRepository.findById(tarea.getId()).orElse(null);
        if (t != null) {
            t.setTitulo(tarea.getTitulo());
            t.setResumen(tarea.getResumen());
            t.setFecha(tarea.getFecha());
            t.setRealizada(tarea.isRealizada());
            return tareaRepository.save(t); // Guardamos la tarea actualizada y devolvemos el objeto guardado
        } else {
            return null; // Si la tarea no existe, devolvemos null
        }
    }

    @Override
    public Tarea deleteTarea(int id) {
        Tarea t = tareaRepository.findById(id).orElse(null);
        if (t != null) {
            tareaRepository.delete(t);
            return t; // Devolvemos la tarea eliminada
        } else {
            return null; // Si no existe, devolvemos null
        }
    }
}
