package udemy.app.services;

import udemy.app.persistence.entities.Tipo;

import java.util.List;

public interface TipoService {
    List<Tipo> getTipos();
    Tipo addTipo(Tipo tipo);
    Tipo deleteTipo(int id);
}
