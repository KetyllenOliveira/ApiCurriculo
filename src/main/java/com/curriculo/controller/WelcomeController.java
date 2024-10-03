package com.curriculo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
@ComponentScan(basePackages = "com.curriculo")


public class WelcomeController {

    /**
     * Endpoint para boas-vindas à API de Currículos.
     * 
     * @return uma mensagem de boas-vindas em formato de ResponseEntity
     */
    @GetMapping
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Bem-vindo à API de Currículos!");
    }
}



