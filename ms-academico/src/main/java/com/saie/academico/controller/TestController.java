package com.saie.academico.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Enpoint Protegido
@RestController
@RequestMapping("/api")
class TestController {

    @GetMapping("/test")
    public String test() {
        return "Acceso permitido";
    }
}
