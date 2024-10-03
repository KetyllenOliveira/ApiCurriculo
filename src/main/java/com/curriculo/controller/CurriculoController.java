package com.curriculo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curriculo.model.Curriculo;
import com.curriculo.service.CurriculoService;

@RestController
@RequestMapping("/api/curriculos")
public class CurriculoController {

        @Autowired
    private CurriculoService curriculoService;

    @GetMapping
    public List<Curriculo> listarCurriculos() {
        return curriculoService.listarCurriculos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculo> obterCurriculoPorId(@PathVariable Long id) {
        Curriculo curriculo = curriculoService.obterCurriculoPorId(id);
        if (curriculo != null) {
            return ResponseEntity.ok(curriculo);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Curriculo criarCurriculo(@RequestBody Curriculo curriculo) {
        return curriculoService.salvarCurriculo(curriculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curriculo> atualizarCurriculo(@PathVariable Long id, @RequestBody Curriculo curriculo) {
        Curriculo curriculoExistente = curriculoService.obterCurriculoPorId(id);
        if (curriculoExistente != null) {
            curriculoExistente.setNome(curriculo.getNome());
            curriculoExistente.setIdade(curriculo.getIdade());
            curriculoExistente.setSexo(curriculo.getSexo());
            curriculoExistente.setFormacaoAcademica(curriculo.getFormacaoAcademica());
            curriculoExistente.setExperiencia(curriculo.getExperiencia());
            curriculoExistente.setCursosLivres(curriculo.getCursosLivres());
            curriculoExistente.setCertificacao(curriculo.getCertificacao());
            return ResponseEntity.ok(curriculoService.salvarCurriculo(curriculoExistente));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCurriculo(@PathVariable Long id) {
        Curriculo curriculoExistente = curriculoService.obterCurriculoPorId(id);
        if (curriculoExistente != null) {
            curriculoService.deletarCurriculo(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    // Nova rota de boas-vindas
    @GetMapping("/")
    public String paginaInicial() {
        return "Bem vindo à central de currículos";
    }
    
}
