package com.ap.argprogram.repositorios;

import com.ap.argprogram.modelos.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciaRepositorio extends JpaRepository<Experiencia, Long> {
}
