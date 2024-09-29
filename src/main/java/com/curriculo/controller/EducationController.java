package com.curriculo.controller;


import com.curriculo.model.Education;
import com.curriculo.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @GetMapping
    public List<Education>getAllEducation () {
        return educationService.getAllEducation();
    }

    @PostMapping
    public Education createEducation (@RequestBody Education education) {
        return educationService.saveEducation(education);
    }

    @DeleteMapping("/{id}")
    public void deleteEducation(@PathVariable Long id){
        educationService.deleteEducation(id);
    }
}
