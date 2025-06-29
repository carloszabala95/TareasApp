package udemy.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.app.persistence.entities.Tarea;
import udemy.app.persistence.repositories.TareaRepository;

import java.util.List;

@Service
public class TareaServiceImpl implements TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> deleteByUsuarioId(int id) {
        List<Tarea> tareas = tareaRepository.findAllByUsuario_id(id);
        tareaRepository.deleteAll(tareas);
        return tareas;
    }
}
