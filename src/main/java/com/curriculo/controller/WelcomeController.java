package com.curriculo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")  // Mapeia a raiz da aplicação
public class WelcomeController {

    @GetMapping
    public String welcomeMessage() {
        return "Hola, seja bem-vinda à central de currículos!";
    }
}


