package com.ap.argprogram.servicios;

import com.ap.argprogram.modelos.Persona;

import java.util.List;
import java.util.Optional;

public interface IPersonaService {
    public List<Persona> buscarPersonas();

    public Persona crearPersona(Persona per);

    public void borrarPersona( Long id);

    public Optional buscarPersona(Long id);
}
