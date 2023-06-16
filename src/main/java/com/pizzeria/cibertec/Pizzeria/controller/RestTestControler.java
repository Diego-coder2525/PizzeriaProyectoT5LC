package com.pizzeria.cibertec.Pizzeria.controller;

import com.pizzeria.cibertec.Pizzeria.model.response.HistorialQuery;
import com.pizzeria.cibertec.Pizzeria.service.DetallePedidoPizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestTestControler {
    @Autowired
    DetallePedidoPizzaService detallePedidoPizzaService;

    @GetMapping("/getHistorial/{id}")
    public List<HistorialQuery> getHistorial(@PathVariable Integer id){
        return detallePedidoPizzaService.listarHistorial(id);
    }
}
