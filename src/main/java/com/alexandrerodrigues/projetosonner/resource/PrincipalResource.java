package com.alexandrerodrigues.projetosonner.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class PrincipalResource {
    @GetMapping
    public String getHello() {

        return "Página principal ta on!";

    }
}
