package udemy.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udemy.app.persistence.entities.Tipo;
import udemy.app.services.TipoService;

@RestController
@RequestMapping("/tipos")
public class TipoRestController {

    @Autowired
    private TipoService tipoService;

    @GetMapping
    private ResponseEntity<?> getTipos() {
        return ResponseEntity.ok(tipoService.getTipos());
    }

    @PostMapping
    private ResponseEntity<?> addTipo(@RequestBody Tipo tipo) {
        return ResponseEntity.ok(tipoService.addTipo(tipo));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteTipo(@PathVariable int id) {
        return ResponseEntity.ok(tipoService.deleteTipo(id));
    }

}
