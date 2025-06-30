package udemy.app.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import udemy.app.persistence.entities.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer> {
    Tipo findByNombre(String nombre);
    Tipo findById(int id);
}
