package com.pizzeria.cibertec.Pizzeria.service;

import com.pizzeria.cibertec.Pizzeria.model.db.PizzaModel;
import com.pizzeria.cibertec.Pizzeria.repository.PizzaRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {
    @Autowired
    private PizzaRespository pizzaRespository;

    public List<PizzaModel> listaPizza(){
        return (List)pizzaRespository.findAll();
    }
    public void registrarPizza(PizzaModel pizzaClass){
        pizzaRespository.save(pizzaClass);
    }
    public void eliminarPizza(Integer id_pizza){
        pizzaRespository.deleteById(id_pizza);
    }
}
