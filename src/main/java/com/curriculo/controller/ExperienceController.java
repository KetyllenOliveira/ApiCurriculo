package com.curriculo.controller;

import com.curriculo.model.Experience;
import com.curriculo.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/api/experiences")
public class ExperienceController {


    @Autowired
    private ExperienceService experienceService;

    @GetMapping
    public List <Experience> getAllExperiences (){
        return experienceService.getAllExperiences();
    }

    @PostMapping
    public  Experience createExperience (@RequestBody Experience experience){
        return experienceService.saveExperience(experience);
    }

    @DeleteMapping("/{id}")
    public void deleteExperience(@PathVariable Long id){
        experienceService.deleteExperience(id);
    }
}
