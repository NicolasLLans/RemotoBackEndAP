package com.ap.argprogram.servicios;

import com.ap.argprogram.modelos.Educacion;
import com.ap.argprogram.repositorios.EducacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EducacionService implements IEducacionService{
    @Autowired
    private EducacionRepositorio educacionRepo;

    @Override
    public List<Educacion> buscarEducaciones() {
        return educacionRepo.findAll();
    }

    @Override
    public Educacion crearEducacion(Educacion edu) {
        return educacionRepo.save(edu);
    }

    @Override
    public void borrarEducacion(Long id) {
        educacionRepo.deleteById(id);
    }

    @Override
    public Optional<Educacion> buscarEducacion(Long id) {
        return educacionRepo.findById(id);
    }
}
