package com.pizzeria.cibertec.Pizzeria.controller;

import com.pizzeria.cibertec.Pizzeria.model.response.HistorialQuery;
import com.pizzeria.cibertec.Pizzeria.service.DetallePedidoPizzaService;
import com.pizzeria.cibertec.Pizzeria.service.UsuarioService;
import com.pizzeria.cibertec.Pizzeria.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HistorialController {
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    DetallePedidoPizzaService detallePedidoPizzaService;


    @GetMapping("/historial")
    public String historial(Model model) {
        String emailAuth = Util.obtenerEmailAuth();
        int id_usuario = usuarioService.buscarUsuarioPorEmail(emailAuth).getId_usuario();
        List<HistorialQuery> historial = detallePedidoPizzaService.listarHistorial(id_usuario);
        model.addAttribute("historial", historial);
        return "historial";
    }
    @PostMapping("/historial")
    public String historialParam(Model model){

        return "historial";
    }


}
