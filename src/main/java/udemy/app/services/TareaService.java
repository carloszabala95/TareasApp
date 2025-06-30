package udemy.app.services;

import udemy.app.dto.InfoTareaResponse;
import udemy.app.persistence.entities.Tarea;

import java.time.LocalDate;
import java.util.List;

public interface TareaService {

    List<Tarea> deletetareaByTipoId(int id);
    List<Tarea> getTareas(String username);

    Tarea addTarea(String username, String tipo, Tarea tarea);
    Tarea updateTarea(Tarea tarea);
    Tarea deleteTarea(int id);
    List<Tarea> getTareas(String username, LocalDate fecha);
    List<Tarea> getTareas(String username, boolean realizadas);
    List<InfoTareaResponse> getInfoTareas();
}
