package com.ap.argprogram.servicios;

import com.ap.argprogram.modelos.Experiencia;
import com.ap.argprogram.repositorios.ExperienciaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienciaService implements IExperienciaService{
    @Autowired
    private ExperienciaRepositorio experienciaRepo;

    @Override
    public List<Experiencia> buscarExperiencias() {
        return experienciaRepo.findAll();
    }

    @Override
    public Experiencia crearExperiencia(Experiencia exp) {
        return experienciaRepo.save(exp);
    }

    @Override
    public void borrarExperiencia(Long id) {
        experienciaRepo.deleteById(id);
    }

    @Override
    public Optional<Experiencia> buscarExperiencia(Long id) {
        return experienciaRepo.findById(id);
    }
}
