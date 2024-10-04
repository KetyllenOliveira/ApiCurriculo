package com.curriculo.controller;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.curriculo.model.Curriculo;
import com.curriculo.service.CurriculoService;

@RestController
@RequestMapping("/curriculo")


public class CurriculoController {

    @Autowired 
    private CurriculoService CurriculoService;

        // Retorna a lista de todos os currículos
    @GetMapping
    public ResponseEntity<List<Curriculo>> listarCurriculos() {
        List<Curriculo> curriculos = CurriculoService.listarCurriculos();
        if (curriculos.isEmpty()) {
            return ResponseEntity.noContent().build();  // Retorna status 204 se a lista estiver vazia
        }
        return ResponseEntity.ok(curriculos);
    }

    // Retorna um currículo específico por ID
    @GetMapping("/{id}")
    public ResponseEntity<Curriculo> obterCurriculoPorId(@PathVariable Long id) {
        return CurriculoService.obterCurriculoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Cria um novo currículo
    @PostMapping
    public ResponseEntity<Curriculo> criarCurriculo(@RequestBody Curriculo curriculo) {
        if (curriculo == null) {
            return ResponseEntity.badRequest().build();  // Verifica se o corpo da requisição está vazio
        }
        Curriculo novoCurriculo = CurriculoService.salvarCurriculo(curriculo);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                            .path("/{id}")
                            .buildAndExpand(novoCurriculo.getId())
                            .toUri();
        return ResponseEntity.created(location).body(novoCurriculo);  // Retorna 201 Created com o header Location
    }

    // Atualiza um currículo existente
    @PutMapping("/{id}")
    public ResponseEntity<Curriculo> atualizarCurriculo(@PathVariable Long id, @RequestBody Curriculo curriculo) {
        if (curriculo == null) {
            return ResponseEntity.badRequest().build();  // Verifica se o corpo da requisição está vazio
        }
        return CurriculoService.obterCurriculoPorId(id)
                .map(curriculoExistente -> {
                    curriculoExistente.atualizarDados(curriculo);
                    Curriculo atualizado = CurriculoService.salvarCurriculo(curriculoExistente);
                    return ResponseEntity.ok(atualizado);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deleta um currículo específico por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCurriculo(@PathVariable Long id) {
        return CurriculoService.obterCurriculoPorId(id)
                .map(curriculo -> {
                    CurriculoService.deletarCurriculo(id);
                    return ResponseEntity.noContent().build();  // Retorna status 204 No Content
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
}
