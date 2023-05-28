package com.pizzeria.cibertec.Pizzeria.controller;

import com.pizzeria.cibertec.Pizzeria.model.UsuarioClass;
import com.pizzeria.cibertec.Pizzeria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



import java.text.SimpleDateFormat;
        import java.util.Date;

@Controller
public class UsuarioController{

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/registroUsuario")
    public String usuario(Model model) {
        model.addAttribute("usuarioClass", new UsuarioClass());
        return "registro";
    }

    @PostMapping("/registroUsuario")
    public String registroUsuario(@ModelAttribute("usuarioClass") UsuarioClass usuarioClass, Model model) {
        try{
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaFormateada = formatoFecha.parse(formatoFecha.format(usuarioClass.getFecha_registro()));
            usuarioClass.setFecha_registro(fechaFormateada);
            usuarioService.registrarUsuario(usuarioClass);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        return "registro";
    }}


