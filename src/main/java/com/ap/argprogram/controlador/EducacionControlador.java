package com.ap.argprogram.controlador;

import com.ap.argprogram.modelos.Educacion;
import com.ap.argprogram.servicios.IEducacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/educacion")
public class EducacionControlador {

    @Autowired
    private IEducacionService educacionService;

    @GetMapping
    public ResponseEntity<?> TraerEducaciones(){
        return ResponseEntity.ok(educacionService.buscarEducaciones());
    }

    @PostMapping
    public ResponseEntity<?> crearEducacion(@RequestBody Educacion nuevaedu) {
        return ResponseEntity.status(HttpStatus.CREATED).body(educacionService.crearEducacion(nuevaedu));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> traerEducacion(@PathVariable Long id){
        Optional<Educacion> oEducacion = educacionService.buscarEducacion(id);
        if (oEducacion.isPresent()){
            return ResponseEntity.ok(oEducacion);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> BorrarEducacion(@PathVariable Long id){
        Optional<Educacion> oEducacion = educacionService.buscarEducacion(id);
        if (oEducacion.isPresent()){
            educacionService.borrarEducacion(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping({"/{id}"})
    public ResponseEntity<?> editarEducacion(@PathVariable Long id, @RequestBody Educacion edu){
        Optional<Educacion> oEdu = educacionService.buscarEducacion(id);
        if (oEdu.isPresent()){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(educacionService.crearEducacion(edu));
        }
        return ResponseEntity.notFound().build();
    }
}
