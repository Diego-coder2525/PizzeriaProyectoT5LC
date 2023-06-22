package com.pizzeria.cibertec.Pizzeria.service;

import com.pizzeria.cibertec.Pizzeria.model.db.ReservaModel;
import com.pizzeria.cibertec.Pizzeria.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository reservaRepository;

    public List<ReservaModel> listarReserva(){
        return reservaRepository.findAll();
    }

    //public ReservaModel listarReservaId(Integer id){return reservaRepository.findAllById()}
    public void registrarReserva(ReservaModel reservaModel){
        reservaRepository.save(reservaModel);
    }
    public void eliminarReserva(Integer idreserva){
        reservaRepository.deleteById(idreserva);
    }

}
