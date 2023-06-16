package com.pizzeria.cibertec.Pizzeria.controller;

import com.pizzeria.cibertec.Pizzeria.model.response.HistorialQuery;
import com.pizzeria.cibertec.Pizzeria.service.DetallePedidoPizzaService;
import com.pizzeria.cibertec.Pizzeria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.addAttribute("listaUsuarios",usuarioService.listarUsuario());

        return "historial";
    }
    @PostMapping("/historial")
    public String historialParam(@RequestParam("usuario") Integer id_usuario,Model model){
        List<HistorialQuery> historial = detallePedidoPizzaService.listarHistorial(id_usuario);
        model.addAttribute("historial", historial);
        model.addAttribute("listaUsuarios", usuarioService.listarUsuario());
        return "historial";
    }

}
