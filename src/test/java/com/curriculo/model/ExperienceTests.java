package com.curriculo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class ExperienceTests {
    @Test
    public void testGettersAndSetters() {
        Experience experience = new Experience();

        // Definir valores
        experience.setId(1L);
        experience.setJobTittle("Software Quality Tester");
        experience.setCompany("TechCorp");
        experience.setDescription("Tester web applications");
        experience.setStartDate("2021-01-01");
        experience.setEndDate("2023-09-01");

        // Verificar se os valores foram atribuídos corretamente
        assertEquals(1L, experience.getId());
        assertEquals("Software Engineer", experience.getJobTittle());
        assertEquals("TechCorp", experience.getCompany());
        assertEquals("Developing web applications", experience.getDescription());
        assertEquals("2021-01-01", experience.getStartDate());
        assertEquals("2023-09-01", experience.getEndDate());
    }
}
