package udemy.app.services;

import udemy.app.persistence.entities.Tarea;

import java.util.List;

public interface TareaService {
    List<Tarea> deleteByUsuarioId(int id);
}
