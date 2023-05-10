package com.ap.argprogram.controlador;

import com.ap.argprogram.modelos.Skill;
import com.ap.argprogram.servicios.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/skills")
//@CrossOrigin(origins = "/**")
public class SkillControlador {

    @Autowired
    private ISkillService skillService;

    @GetMapping
    public ResponseEntity<?> TraerSkills(){
        return ResponseEntity.ok(skillService.buscarSkills());
    }

    @PostMapping
    public ResponseEntity<?> crearSkill(@RequestBody Skill nuevaSkill) {
        return ResponseEntity.status(HttpStatus.CREATED).body(skillService.crearSkill(nuevaSkill));
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> traerSkill(@PathVariable Long id){
        Optional<Skill> oSkill = skillService.buscarSkill(id);
        if (oSkill.isPresent()){
            return ResponseEntity.ok(oSkill);
        }
        return ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> BorrarSkill(@PathVariable Long id){
        Optional<Skill> oSkill = skillService.buscarSkill(id);
        if (oSkill.isPresent()){
            skillService.borrarSkill(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping({"/{id}"})
    public ResponseEntity<?> editarSkill(@PathVariable Long id, @RequestBody Skill skill){
        Optional<Skill> oSkill = skillService.buscarSkill(id);
        if (oSkill.isPresent()){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(skillService.crearSkill(skill));
        }
        return ResponseEntity.notFound().build();
    }
}
