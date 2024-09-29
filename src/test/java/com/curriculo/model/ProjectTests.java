package com.curriculo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ProjectTests {
    
    @Test
    public void testGettersAndSetters() {
        Project project = new Project();

        // Definir valores
        project.setId(1L);
        project.setName("Currículo API");
        project.setDescription("API para gerenciar currículos.");

        // Verificar se os valores foram atribuídos corretamente
        assertEquals(1L, project.getId());
        assertEquals("Currículo API", project.getName());
        assertEquals("API para gerenciar currículos.", project.getDescription());
    }
}
