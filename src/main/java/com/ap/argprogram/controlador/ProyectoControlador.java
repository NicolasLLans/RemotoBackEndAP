package com.ap.argprogram.controlador;

import com.ap.argprogram.modelos.Proyecto;
import com.ap.argprogram.servicios.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/proyectos")
//@CrossOrigin(origins = "/**")
public class ProyectoControlador {

    @Autowired
    private IProyectoService proyectoService;

    @GetMapping
    public ResponseEntity<?> TraerProyectos(){
        return ResponseEntity.ok(proyectoService.buscarProyectos());
    }

    @PostMapping
    public ResponseEntity<?> crearProyecto(@RequestBody Proyecto nuevaproy) {
        return ResponseEntity.status(HttpStatus.CREATED).body(proyectoService.crearProyecto(nuevaproy));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> traerProyecto(@PathVariable Long id){
        Optional<Proyecto> oProy = proyectoService.buscarProyecto(id);
        if (oProy.isPresent()){
            return ResponseEntity.ok(oProy);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> BorrarProyecto(@PathVariable Long id){
        Optional<Proyecto> oProy = proyectoService.buscarProyecto(id);
        if (oProy.isPresent()){
            proyectoService.borrarProyecto(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping({"/{id}"})
    public ResponseEntity<?> editarProyecto(@PathVariable Long id, @RequestBody Proyecto proyecto){
        Optional<Proyecto> oProy = proyectoService.buscarProyecto(id);
        if (oProy.isPresent()){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(proyectoService.crearProyecto(proyecto));
        }
        return ResponseEntity.notFound().build();
    }
}
