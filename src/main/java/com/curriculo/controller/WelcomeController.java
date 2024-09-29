package com.curriculo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")  // Mapeia a raiz da aplicação
public class WelcomeController {

@GetMapping("/")
public ResponseEntity<String> welcomeMessage() {
    return ResponseEntity.ok("Hola, seja bem-vinda à central de currículos!");
}

}


