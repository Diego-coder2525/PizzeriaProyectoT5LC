package com.pizzeria.cibertec.Pizzeria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzeria.cibertec.Pizzeria.model.MesaModel;
import com.pizzeria.cibertec.Pizzeria.repository.MesaRepository;

@Service
public class MesaService {
    @Autowired
    private MesaRepository mesaRepository;
    
    public List<MesaModel> listarMesa(){
		return mesaRepository.findAll();
	}
    
    public void registrarMesa (MesaModel mesa){
    	mesaRepository.save(mesa);
    }
    public void eliminarMesa(Integer id_mesa) {
    	mesaRepository.deleteById(id_mesa);
    }

}
