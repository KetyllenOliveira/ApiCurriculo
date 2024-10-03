package com.curriculo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curriculo.model.Curriculo;
import com.curriculo.repository.CurriculoRepository;

@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository curriculoRepository;

    public List<Curriculo> listarCurriculos() {
        return curriculoRepository.findAll();
    }

    // Atualizado para retornar Optional<Curriculo>
    public Optional<Curriculo> obterCurriculoPorId(Long id) {
        return curriculoRepository.findById(id);
    }

    public Curriculo salvarCurriculo(Curriculo curriculo) {
        return curriculoRepository.save(curriculo);
    }

    public void deletarCurriculo(Long id) {
        curriculoRepository.deleteById(id);
    }
}
