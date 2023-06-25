package com.pizzeria.cibertec.Pizzeria.controller;

import com.pizzeria.cibertec.Pizzeria.model.db.UsuarioModel;
import com.pizzeria.cibertec.Pizzeria.service.UsuarioService;
import com.pizzeria.cibertec.Pizzeria.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

// Controlador compartido entre los controladores
@ControllerAdvice
public class GlobalController {
    private UsuarioService usuarioService;

    @Autowired
    public void GlobalControllerAdvice(UsuarioService userService) {
        this.usuarioService = userService;
    }
    @ModelAttribute("user")
    public String globalUser() {
        UsuarioModel user = usuarioService.buscarUsuarioPorEmail(Util.obtenerEmailAuth());
        return user.getNombreusuario();
    }
}
