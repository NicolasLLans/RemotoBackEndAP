package com.ap.argprogram.servicios;

import com.ap.argprogram.modelos.Skill;
import com.ap.argprogram.repositorios.SkillRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService implements ISkillService{
    @Autowired
    private SkillRepositorio skillRepo;

    @Override
    public List<Skill> buscarSkills() {
        return skillRepo.findAll();
    }

    @Override
    public Skill crearSkill(Skill skill) {
        return skillRepo.save(skill);
    }

    @Override
    public void borrarSkill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Optional<Skill> buscarSkill(Long id) {
        return skillRepo.findById(id);
    }
}
