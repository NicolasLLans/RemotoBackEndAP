package com.ap.argprogram.controlador;

import com.ap.argprogram.modelos.Experiencia;
import com.ap.argprogram.servicios.IExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/experiencia")
//@CrossOrigin(origins = "/**")
public class ExperienciaControlador {

    @Autowired
    private IExperienciaService experienciaService;

    @GetMapping
    public ResponseEntity<?> TraerExperiencias(){
        return ResponseEntity.ok(experienciaService.buscarExperiencias());
    }

    @PostMapping
    public ResponseEntity<?> crearExperiencia(@RequestBody Experiencia nuevaexp) {
        return ResponseEntity.status(HttpStatus.CREATED).body(experienciaService.crearExperiencia(nuevaexp));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> traerExperiencia(@PathVariable Long id){
        Optional<Experiencia> oExp = experienciaService.buscarExperiencia(id);
        if (oExp.isPresent()){
            return ResponseEntity.ok(oExp);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> BorrarExperiencia(@PathVariable Long id){
        Optional<Experiencia> oExp = experienciaService.buscarExperiencia(id);
        if (oExp.isPresent()){
            experienciaService.borrarExperiencia(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping({"/{id}"})
    public ResponseEntity<?> editarExperiecia(@PathVariable Long id, @RequestBody Experiencia exp){
        Optional<Experiencia> oExp = experienciaService.buscarExperiencia(id);
        if (oExp.isPresent()){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(experienciaService.crearExperiencia(exp));
        }
        return ResponseEntity.notFound().build();
    }
}
