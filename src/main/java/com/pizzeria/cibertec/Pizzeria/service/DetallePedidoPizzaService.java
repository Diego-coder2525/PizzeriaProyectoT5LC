package com.pizzeria.cibertec.Pizzeria.service;

import com.pizzeria.cibertec.Pizzeria.model.db.DetallePedidoPizzaModel;
import com.pizzeria.cibertec.Pizzeria.model.response.HistorialQuery;
import com.pizzeria.cibertec.Pizzeria.repository.DetallePedidoPizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetallePedidoPizzaService {
    @Autowired
    DetallePedidoPizzaRepository detallePedidoPizzaRepository;

    public void registrarDPP(DetallePedidoPizzaModel detallePedidoPizza){
        detallePedidoPizzaRepository.save(detallePedidoPizza);
    }
    public List<DetallePedidoPizzaModel> listarDPP(){
        return detallePedidoPizzaRepository.findAll();
    }

    public List<HistorialQuery> listarHistorial(Integer id_usuario){
        return detallePedidoPizzaRepository.ejecutarConsultaCompleja(id_usuario);
    }
}
