package com.curriculo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return curriculoService.obterCurriculoPorId(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Curriculo criarCurriculo(@RequestBody Curriculo curriculo) {
        return curriculoService.salvarCurriculo(curriculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curriculo> atualizarCurriculo(@PathVariable Long id, @RequestBody Curriculo curriculo) {
        return curriculoService.obterCurriculoPorId(id)
            .map(curriculoExistente -> {
                curriculoExistente.atualizarDados(curriculo);
                return ResponseEntity.ok(curriculoService.salvarCurriculo(curriculoExistente));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCurriculo(@PathVariable Long id) {
        return curriculoService.obterCurriculoPorId(id)
            .map(curriculo -> {
                curriculoService.deletarCurriculo(id);
                return ResponseEntity.noContent().build();
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    public String paginaInicial() {
        return "Bem vindo à central de currículos";
    }
}
