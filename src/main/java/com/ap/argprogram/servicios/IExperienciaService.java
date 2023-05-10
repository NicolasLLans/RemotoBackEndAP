package com.ap.argprogram.servicios;

import com.ap.argprogram.modelos.Experiencia;

import java.util.List;
import java.util.Optional;

public interface IExperienciaService {
    public List<Experiencia> buscarExperiencias();

    public Experiencia crearExperiencia(Experiencia exp);

    public void borrarExperiencia( Long id);

    public Optional buscarExperiencia(Long id);

}
