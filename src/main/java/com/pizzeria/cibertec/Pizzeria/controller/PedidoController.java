package com.pizzeria.cibertec.Pizzeria.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.pizzeria.cibertec.Pizzeria.model.PizzaClass;
import com.pizzeria.cibertec.Pizzeria.model.request.PizzaRequest;
import com.pizzeria.cibertec.Pizzeria.model.request.ReservaRequest;
import com.pizzeria.cibertec.Pizzeria.service.PizzaService;
import com.pizzeria.cibertec.Pizzeria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.pizzeria.cibertec.Pizzeria.model.PedidoModel;
import com.pizzeria.cibertec.Pizzeria.service.PedidoService;

@Controller
public class PedidoController {

	@Autowired
	PedidoService pedidoservice;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	PizzaService pizzaService;

	public static ArrayList<PizzaClass> listaPizzasXID = new ArrayList<>();
	@GetMapping("/frmManPedido")
	public String frmManPedido(Model model) {
		model.addAttribute("listaPedido", pedidoservice.listarPedidos());
		model.addAttribute("listaPizza",pizzaService.listaPizza());
		return "listaPedido";
	}

	@GetMapping("/frmRegPedido")
	public String frmRegPedido(Model model) {
		model.addAttribute("pedidoForm", new PedidoModel());
		model.addAttribute("visualizar", false);
		model.addAttribute("usuarios", usuarioService.listarUsuario());
		return "registrarPedido";
	}

	@PostMapping("/frmPizzaEscogida")
	public String pizzaEscogida(@RequestParam("pizza") PizzaClass pizza) {
		// Lógica para procesar la pizza escogida con el ID recibido
		listaPizzasXID.add(pizza);
		// redirecciona, es decir renderiza la imagen y ejecuta la peticion, a diferencia de solo return "vista"
		return "redirect:/frmManPedido";
	}

	@PostMapping("frmRegPedido")
    public String registroPedido(@ModelAttribute("pedidoForm") PedidoModel pedidoModel, Model model) {
		String mensaje="Pedido registrado correctamente";
        try{
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            //Date fechaFormateada = formatoFecha.parse(formatoFecha.format(pedidoModel.getFecha_pedido()));
            //pedidoModel.setFecha_pedido(fechaFormateada);
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
