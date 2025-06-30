package udemy.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import udemy.app.persistence.entities.Tarea;
import udemy.app.services.TareaService;

@RestController
@RequestMapping("/tareas")
public class TareaRestController {
    // Assuming there's a TareaService to handle business logic
    @Autowired
    private TareaService tareaService;

    @GetMapping("/{username}")
    public ResponseEntity<?> getTareas(@PathVariable("username") String username) {
        return ResponseEntity.ok(tareaService.getTareas(username));
    }

    @PostMapping("/{username}/{tipo}")
    private ResponseEntity<?> addTarea(@PathVariable("username") String username, @PathVariable("tipo") String tipo, @RequestBody Tarea tarea) {
        Tarea t = tareaService.addTarea(username, tipo, tarea);
        return ResponseEntity.ok(t);
    }

    @PutMapping
    private ResponseEntity<?> updateTarea(@RequestBody Tarea tarea) {
        // Assuming there's an update method in the service
        return ResponseEntity.ok(tareaService.updateTarea(tarea));
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteTarea(@PathVariable("id") int id) {
        return ResponseEntity.ok(tareaService.deleteTarea(id));
    }

}
