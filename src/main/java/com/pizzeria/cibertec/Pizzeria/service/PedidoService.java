package com.pizzeria.cibertec.Pizzeria.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizzeria.cibertec.Pizzeria.model.db.PedidoModel;
import com.pizzeria.cibertec.Pizzeria.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<PedidoModel> listarPedidos(){
		return pedidoRepository.findAll();
	}
	
	public void registrarPedido(PedidoModel pedido) {
		pedidoRepository.save(pedido);
	}
	public PedidoModel ultimoPedido(){return pedidoRepository.obtenerUltimoRegistro();}

}
