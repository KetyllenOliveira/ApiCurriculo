package com.curriculo.service;

import com.curriculo.model.Education;
import com.curriculo.repository.EducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {

    @Autowired
    private EducationRepository educationRepository;

    // Método para obter todas as educações
    public List<Education> getAllEducation() {
        return educationRepository.findAll();
    }

    // Método para salvar uma nova educação
    public Education saveEducation(Education education) {
        return educationRepository.save(education);
    }

    // Método para excluir uma educação
    public void deleteEducation(Long id) {
        if (educationRepository.existsById(id)) { // Verifica se a educação existe
            educationRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Educação com ID " + id + " não encontrada."); // Lança uma exceção se não encontrado
        }
    }
}
