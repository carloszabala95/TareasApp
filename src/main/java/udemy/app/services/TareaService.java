package udemy.app.services;

import udemy.app.persistence.entities.Tarea;

import java.util.List;

public interface TareaService {

    List<Tarea> deletetareaByTipoId(int id);
    List<Tarea> getTareas(String username);

    Tarea addTarea(String username, String tipo, Tarea tarea);
    Tarea updateTarea(Tarea tarea);
    Tarea deleteTarea(int id);
}
