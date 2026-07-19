package com.uisrael.consumoweb.controller.View;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping({"/", "/login"})
    public String mostrarLogin() {
        // Al hacer el refactor del HTML a login.html, aquí devuelves "login"
        return "login"; 
    }
}