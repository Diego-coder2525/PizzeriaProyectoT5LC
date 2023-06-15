package com.pizzeria.cibertec.Pizzeria.service;

import com.pizzeria.cibertec.Pizzeria.model.DetallePedidoPizza;
import com.pizzeria.cibertec.Pizzeria.repository.DetallePedidoPizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoPizzaService {
    @Autowired
    DetallePedidoPizzaRepository detallePedidoPizzaRepository;

    public void registrarDPP(DetallePedidoPizza detallePedidoPizza){
        detallePedidoPizzaRepository.save(detallePedidoPizza);
    }
    public List<DetallePedidoPizza> listarDPP(){
        return detallePedidoPizzaRepository.findAll();
    }
}
