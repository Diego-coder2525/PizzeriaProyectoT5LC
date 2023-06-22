package com.pizzeria.cibertec.Pizzeria.controller;

import com.pizzeria.cibertec.Pizzeria.model.db.UsuarioModel;
import com.pizzeria.cibertec.Pizzeria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;
    @GetMapping("/login")
    public String login() {
        return "auth/login";
    }
    @GetMapping("/register")
    public String registrar() {
        return "auth/register";
    }

    @PostMapping("/saveUser")
    public String guardarUsuario(@ModelAttribute UsuarioModel usuario,Model model) {
        usuarioService.guardarUsuario(usuario);
        model.addAttribute("registroCorrecto",true);
        return "auth/register";
    }
}