package com.curriculo.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EducationTests {

    @Test

    public void testGettersAndSetters (){

        Education education = new Education ();

        //Definindo valores 
        education.setId(1L);
        education.setDegree("Techonology of Sistems of Internet");
        education.setInstitution("Universidade Católica de Pernambuco");
        education.setYear(2023);


        //Verificando se os valores foram atribuidos corretamente 

        assertEquals(1L, education.getId());
        assertEquals("Techonology of Sistems of Internet", education.getDegree());
        assertEquals("Universidade Católica de Pernambuco", education.getInstitution());
        assertEquals(2024, education.getYear());

    }
    
}
