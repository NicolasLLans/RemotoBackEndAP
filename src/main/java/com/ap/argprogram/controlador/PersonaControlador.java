package com.ap.argprogram.controlador;

import com.ap.argprogram.modelos.Persona;
import com.ap.argprogram.servicios.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/personas")
//@CrossOrigin(origins = "/**")
public class PersonaControlador {
    @Autowired
    private IPersonaService personaService;

    @GetMapping
    public ResponseEntity<?> TraerPersonas(){
        return ResponseEntity.ok(personaService.buscarPersonas());
    }

    @PostMapping
    public ResponseEntity<?> crearUsuario(@RequestBody Persona persona) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personaService.crearPersona(persona));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> traerPersona(@PathVariable Long id){
        Optional<Persona> oPersona = personaService.buscarPersona(id);
        if (oPersona.isPresent()){
            return ResponseEntity.ok(oPersona);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> BorrarPersona(@PathVariable Long id){
        Optional<Persona> oPersona = personaService.buscarPersona(id);
        if (oPersona.isPresent()){
            personaService.borrarPersona(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> editarPersona(@PathVariable Long id, @RequestBody Persona persona){
        Optional<Persona> oPersona = personaService.buscarPersona(id);
        if (oPersona.isPresent()){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(personaService.crearPersona(persona));
        }
        return ResponseEntity.notFound().build();
    }
}
