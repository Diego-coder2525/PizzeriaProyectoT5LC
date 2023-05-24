package com.pizzeria.cibertec.Pizzeria.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.pizzeria.cibertec.Pizzeria.model.PedidoModel;
import com.pizzeria.cibertec.Pizzeria.service.PedidoService;

@Controller
public class PedidoController {
	
	@Autowired
	PedidoService pedidoservice;
	
	@GetMapping("/frmManPedido")
	public String frmManPedido(Model model) {
		model.addAttribute("listaPedido", pedidoservice.listarPedidos());
		return "listaPedido";
	}
	
	@GetMapping("/frmRegPedido")
	public String frmRegPedido(Model model) {
		model.addAttribute("pedidoForm", new PedidoModel());
		model.addAttribute("visualizar", false);
		return "registrarPedido";
	}
	
	@PostMapping("frmRegPedido")
    public String registroPedido(@ModelAttribute("pedidoForm") PedidoModel pedidoModel, Model model) {
		String mensaje="Pedido registrado correctamente";
        try{
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaFormateada = formatoFecha.parse(formatoFecha.format(pedidoModel.getFecha_pedido()));
            pedidoModel.setFecha_pedido(fechaFormateada);
            pedidoservice.registrarPedido(pedidoModel);
        }
        catch(Exception e) {
        	mensaje="Pedido no registrado";
        }
		model.addAttribute("pedidoForm", new PedidoModel());
		model.addAttribute("visualizar", true);
		model.addAttribute("respuesta", mensaje);
        return "registrarPedido";
    }

}
