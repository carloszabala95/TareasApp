package udemy.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.app.controllers.TipoRestController;
import udemy.app.persistence.entities.Tipo;
import udemy.app.persistence.repositories.TareaRepository;
import udemy.app.persistence.repositories.TipoRepository;

import java.util.List;

@Service
public class TipoServiceImpl implements TipoService {
    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private TareaService tareaService;


    @Override
    public List<Tipo> getTipos() {
        List<Tipo> tipos = tipoRepository.findAll();
        return tipos;
    }

    @Override
    public Tipo addTipo(Tipo tipo) {
        Tipo tipoExistente = tipoRepository.findByNombre(tipo.getNombre());
        if (tipoExistente == null) { // Si no existe un tipo con el mismo nombre, lo añadimos
            return tipoRepository.save(tipo);
        } else {
            return null; // Si ya existe, no lo añadimos
        }
    }

    @Override
    public Tipo deleteTipo(int id) {

        Tipo tipo = tipoRepository.findById(id);
        if (tipo.getNombre() != null) {
            tareaService.deletetareaByTipoId(id); //Borrar primero dado que es FK
            tipoRepository.delete(tipo);
            return tipo; // Devolvemos el tipo eliminado
        } else {
            return null; // Si no existe, devolvemos null
        }
    }
}
