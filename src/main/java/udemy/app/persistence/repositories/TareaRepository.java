package udemy.app.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udemy.app.persistence.entities.Tarea;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
    List<Tarea> findAllByUsuario_id(int id);
    List<Tarea> findAllByTipo_id(int id);
}
