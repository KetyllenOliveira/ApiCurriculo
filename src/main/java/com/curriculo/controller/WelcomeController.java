package com.curriculo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api") // Mapeia o prefixo "/api" para este controlador
public class WelcomeController {

    /**
     * Endpoint para boas-vindas à API de Currículos.
     * 
     * @return uma mensagem de boas-vindas em formato de ResponseEntity
     */
    @GetMapping("/welcome") // Acesso em "/api/welcome"
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Bem-vindo à API de Currículos!");
    }
}



