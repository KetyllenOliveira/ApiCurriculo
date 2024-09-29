package com.curriculo.service;

import com.curriculo.model.Experience;
import com.curriculo.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    // Método para obter todas as experiências
    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    // Método para salvar uma nova experiência
    public Experience saveExperience(Experience experience) {
        return experienceRepository.save(experience); // Salva a experiência e retorna o objeto salvo
    }

    // Método para excluir uma experiência
    public boolean deleteExperience(Long id) {
        if (experienceRepository.existsById(id)) { // Verifica se a experiência existe
            experienceRepository.deleteById(id);
            return true; // Retorna true se a exclusão for bem-sucedida
        } else {
            return false; // Retorna false se não encontrar a experiência
        }
    }
}
