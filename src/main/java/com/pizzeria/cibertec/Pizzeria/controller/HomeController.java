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
        @GetMapping ("/inicio")
        public String inicio(){
            return "inicio";
        }
}
