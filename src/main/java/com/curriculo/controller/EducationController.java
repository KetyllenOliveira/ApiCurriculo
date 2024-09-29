package com.curriculo.controller;

import com.curriculo.model.Education;
import com.curriculo.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    @Autowired
    private EducationService educationService;

    @GetMapping
    public List<Education> getAllEducation() {
        return educationService.getAllEducation();
    }

    @PostMapping
    public ResponseEntity<Education> createEducation(@RequestBody Education education) {
        Education createdEducation = educationService.saveEducation(education);
        return ResponseEntity.status(201).body(createdEducation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEducation(@PathVariable Long id) {
        try {
            educationService.deleteEducation(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content se a exclusão for bem-sucedida
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // Retorna 404 Not Found se a educação não existir
        }
    }
}
