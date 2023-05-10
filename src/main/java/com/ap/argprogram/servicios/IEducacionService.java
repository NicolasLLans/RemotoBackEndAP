package com.ap.argprogram.servicios;

import com.ap.argprogram.modelos.Educacion;

import java.util.List;
import java.util.Optional;

public interface IEducacionService {
    public List<Educacion> buscarEducaciones();

    public Educacion crearEducacion(Educacion per);

    public void borrarEducacion( Long id);

    public Optional buscarEducacion(Long id);

}
