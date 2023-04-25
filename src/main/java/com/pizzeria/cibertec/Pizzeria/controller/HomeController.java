package com.pizzeria.cibertec.Pizzeria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Controlador rest para prueba rapida
// @RestController
@Controller
public class HomeController {
    // Padre del @GetMapping
        /*@RequestMapping("/home")
        public String home(){
            return "ASDADSASDASDDASADASDDDDDDDDDDDD";
        }*/
    @GetMapping("/inicio")
    public String inicio() {

        return "inicio";
    }

    @GetMapping("/registro")
    public String registro() {
        return "registro";
    }

    @GetMapping("/reservas")
    public String reservas() {
        return "reservas";
    }

    @GetMapping("/pedidos")
    public String pedidos() {
        return "pedidos";
    }
    @GetMapping("/historial")
    public String historial() {
        return "historial";
    }
    @GetMapping("/contacto")
    public String contacto() {
        return "contacto";
    }
    @GetMapping("/carrito")
    public String carrito() {
        return "carrito";
    }
}
