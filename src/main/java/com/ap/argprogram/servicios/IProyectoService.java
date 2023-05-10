package com.ap.argprogram.servicios;

import com.ap.argprogram.modelos.Proyecto;

import java.util.List;
import java.util.Optional;

public interface IProyectoService {
    public List<Proyecto> buscarProyectos();

    public Proyecto crearProyecto(Proyecto proy);

    public void borrarProyecto( Long id);

    public Optional buscarProyecto(Long id);

}
