package com.ap.argprogram.servicios;

import com.ap.argprogram.modelos.Skill;

import java.util.List;
import java.util.Optional;

public interface ISkillService {
    public List<Skill> buscarSkills();

    public Skill crearSkill(Skill skill);

    public void borrarSkill( Long id);

    public Optional buscarSkill(Long id);

}
