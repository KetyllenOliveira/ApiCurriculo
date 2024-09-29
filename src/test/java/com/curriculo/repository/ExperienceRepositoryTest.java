package com.curriculo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.curriculo.model.Experience;

@DataJpaTest

public class ExperienceRepositoryTest {
        @Autowired
    private ExperienceRepository experienceRepository;

    @Test
    public void testSaveAndFindById() {
        // Criar e salvar uma entidade Experience
        Experience experience = new Experience();
        experience.setJobTittle("Software Engineer");
        experience.setCompany("TechCorp");
        experience.setDescription("Developing web applications");
        experience.setStartDate("2021-01-01");
        experience.setEndDate("2023-09-01");

        // Salvar a entidade no banco de dados
        Experience savedExperience = experienceRepository.save(experience);

        // Verificar se a entidade foi salva corretamente
        assertNotNull(savedExperience.getId());

        // Recuperar a entidade do banco de dados
        Optional<Experience> foundExperience = experienceRepository.findById(savedExperience.getId());

        // Verificar se os valores são iguais
        assertTrue(foundExperience.isPresent());
        assertEquals("Software Engineer", foundExperience.get().getJobTittle());
        assertEquals("TechCorp", foundExperience.get().getCompany());
        assertEquals("Developing web applications", foundExperience.get().getDescription());
        assertEquals("2021-01-01", foundExperience.get().getStartDate());
        assertEquals("2023-09-01", foundExperience.get().getEndDate());
    }
}
