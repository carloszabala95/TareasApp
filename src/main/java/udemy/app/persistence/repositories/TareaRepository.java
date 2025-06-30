package udemy.app.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import udemy.app.dto.InfoTareaResponse;
import udemy.app.persistence.entities.Tarea;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
    List<Tarea> findAllByUsuario_id(int id);
    List<Tarea> findAllByTipo_id(int id);
    List<Tarea> findAllByFechaAndUsuario_id(LocalDate fecha, int id);
    List<Tarea> findAllByRealizadaAndUsuario_id(boolean realizada, int id);
    @Query(value = "SELECT t.titulo, t.resumen, t.fecha, t.realizada, u.username, tip.nombre FROM tarea t left join usuario u on t.usuario_id=u.id left join tipo tip on t.tipo_id=tip.id", nativeQuery = true)
    List<InfoTareaResponse>  getInfoTarea();
}
