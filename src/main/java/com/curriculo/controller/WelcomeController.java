package com.curriculo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") // Adjust this for your security needs
public class WelcomeController {
    @GetMapping("/")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Bem-vindo à API de Currículos!");
    }
}


