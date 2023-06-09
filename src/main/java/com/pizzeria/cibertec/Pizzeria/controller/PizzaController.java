package com.pizzeria.cibertec.Pizzeria.controller;

import com.pizzeria.cibertec.Pizzeria.model.PizzaClass;
import com.pizzeria.cibertec.Pizzeria.model.request.PizzaRequest;
import com.pizzeria.cibertec.Pizzeria.model.response.PizzaResponse;
import com.pizzeria.cibertec.Pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Pizza")
public class PizzaController {

    @Autowired
    PizzaService pizzaService;

    @GetMapping("/listaPizza")
    public String listaPizza(Model model){
        model.addAttribute("listaPizza",pizzaService.listaPizza());
        return "pizza/listaPizza";
    }
    @GetMapping("/listarPizzas")
    @ResponseBody
    public List<PizzaClass> listarPizzas(){
        return pizzaService.listaPizza();
    }

    @PostMapping("/registrarPizza")
    @ResponseBody
    public PizzaResponse registrarPizza(@RequestBody PizzaRequest pizzaRequest){
        String mensaje ="Pizza registrada correctamente :)";
        Boolean respuesta = true;
        try {
            //Se puede aplicar el patrón Builder en estos objetos
            PizzaClass objPizza = new PizzaClass();
            if(pizzaRequest.getId_pizza() > 0) {
                objPizza.setId_pizza(pizzaRequest.getId_pizza());
            }
            objPizza.setNombre(pizzaRequest.getNombre());
            objPizza.setDescripcion(pizzaRequest.getDescripcion());
            objPizza.setPrecio(pizzaRequest.getPrecio());
            pizzaService.registrarPizza(objPizza);
        }catch(Exception ex) {
            mensaje = "Pizza no registrada :(";
            respuesta = false;
        }
        return PizzaResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta)
                .build();
    }
    @DeleteMapping("/eliminarPizza")
    @ResponseBody
    public PizzaResponse eliminarPizza(@RequestBody
                                          PizzaRequest pizzaRequest) {
        String mensaje = "Pizza eliminada correctamente :)";
        Boolean respuesta = true;
        try {
            pizzaService.eliminarPizza(pizzaRequest.getId_pizza());
        }catch (Exception e) {
            mensaje = "Pizza no eliminada :(";
            respuesta = false;
        }
        return PizzaResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta)
                .build();
    }
}
