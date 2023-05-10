package com.ap.argprogram.servicios;

import com.ap.argprogram.modelos.Persona;
import com.ap.argprogram.repositorios.PersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private PersonaRepositorio personaRepo;

    @Override
    public List<Persona> buscarPersonas() {
        return personaRepo.findAll();
    }

    @Override
    public Persona crearPersona(Persona per) {
        return personaRepo.save(per);
    }

    @Override
    public void borrarPersona(Long id) {
        personaRepo.deleteById(id);
    }

    @Override
    public Optional<Persona> buscarPersona(Long id) {
        return personaRepo.findById(id);
    }
}
