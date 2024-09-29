package com.curriculo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.curriculo.model.Project;

@DataJpaTest
public class ProjectRepositoryTest {
    
    @Autowired
    private ProjectRepository projectRepository;

    @Test
    public void testSaveAndFindById() {
        // Criar e salvar uma entidade Project
        Project project = new Project();
        project.setName("Currículo API");
        project.setDescription("API para gerenciar currículos.");

        // Salvar a entidade no banco de dados
        Project savedProject = projectRepository.save(project);

        // Verificar se a entidade foi salva corretamente
        assertNotNull(savedProject.getId());

        // Recuperar a entidade do banco de dados
        Optional<Project> foundProject = projectRepository.findById(savedProject.getId());

        // Verificar se os valores são iguais
        assertTrue(foundProject.isPresent());
        assertEquals("Currículo API", foundProject.get().getName());
        assertEquals("API para gerenciar currículos.", foundProject.get().getDescription());
    }
}
