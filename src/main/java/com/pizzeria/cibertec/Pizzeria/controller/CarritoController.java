package com.pizzeria.cibertec.Pizzeria.controller;

import com.pizzeria.cibertec.Pizzeria.constant.Constant;
import com.pizzeria.cibertec.Pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CarritoController {



    @GetMapping("/carrito")
    @ResponseBody
    public String carrito(Model model, HttpServletRequest request) {


        //return "carrito";
        return "Pizzas escogidas prueba : " + PedidoController.listaPizzasXID;
    }

}
