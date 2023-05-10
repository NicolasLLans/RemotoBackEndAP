package com.ap.argprogram.repositorios;

import com.ap.argprogram.modelos.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepositorio extends JpaRepository<Skill, Long> {
}
