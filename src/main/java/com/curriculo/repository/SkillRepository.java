package com.curriculo.repository;

import com.curriculo.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository <Skill,Long> {
}
