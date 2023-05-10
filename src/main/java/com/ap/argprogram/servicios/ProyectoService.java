package com.ap.argprogram.servicios;

import com.ap.argprogram.modelos.Proyecto;
import com.ap.argprogram.repositorios.ProyectoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService implements IProyectoService{
    @Autowired
    private ProyectoRepositorio proyectoRepo;

    @Override
    public List<Proyecto> buscarProyectos() {
        return proyectoRepo.findAll();
    }

    @Override
    public Proyecto crearProyecto(Proyecto proy) {
        return proyectoRepo.save(proy);
    }

    @Override
    public void borrarProyecto(Long id) {
        proyectoRepo.deleteById(id);
    }

    @Override
    public Optional buscarProyecto(Long id) {
        return proyectoRepo.findById(id);
    }
}
