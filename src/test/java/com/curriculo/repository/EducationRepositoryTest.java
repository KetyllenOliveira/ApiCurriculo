package com.curriculo.repository;

import com.curriculo.model.Education;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class EducationRepositoryTest {

    @Autowired
    private EducationRepository educationRepository;

    @Test
    public void testSaveAndFindById() {
        // Criar e salvar uma entidade Education
        Education education = new Education();
        education.setDegree("Bachelor of Science");
        education.setInstitution("University of Recife");
        education.setYear(2024);

        // Salvar a entidade no banco de dados
        Education savedEducation = educationRepository.save(education);

        // Verificar se a entidade foi salva corretamente
        assertNotNull(savedEducation.getId());

        // Recuperar a entidade do banco de dados
        Optional<Education> foundEducation = educationRepository.findById(savedEducation.getId());

        // Verificar se os valores são iguais
        assertTrue(foundEducation.isPresent());
        assertEquals("Bachelor of Science", foundEducation.get().getDegree());
        assertEquals("University of Recife", foundEducation.get().getInstitution());
        assertEquals(2024, foundEducation.get().getYear());
    }
}
