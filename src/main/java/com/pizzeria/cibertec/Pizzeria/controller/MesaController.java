package com.pizzeria.cibertec.Pizzeria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pizzeria.cibertec.Pizzeria.model.MesaModel;
import com.pizzeria.cibertec.Pizzeria.model.request.MesaRequest;
import com.pizzeria.cibertec.Pizzeria.model.response.ResultadoResponse;
import com.pizzeria.cibertec.Pizzeria.service.MesaService;

@Controller
@RequestMapping("/mesa")
public class MesaController {
	
	@Autowired
	private MesaService mesaService;
	
	@GetMapping("/frmmesa")
	public String frmMantSala(Model model) {
		model.addAttribute("listamesas", 
				mesaService.listarMesa());
		return "mesa/frmmesa";
	}
	
	@PostMapping("/registrarMesa")
	@ResponseBody
	public ResultadoResponse registrarMesa(
			@RequestBody MesaRequest mesaRequest
			) {
		String mensaje ="Mesa registrada correctamente :v";
		Boolean respuesta = true;
		try {			

			MesaModel objMes = new MesaModel();
			if(mesaRequest.getId_mesa() > 0) {
				objMes.setId_mesa(mesaRequest.getId_mesa());
			}
			objMes.setCapacidad(mesaRequest.getCapacidad());
			objMes.setDisponible(mesaRequest.getDisponible());
			mesaService.registrarMesa(objMes);
		}catch(Exception ex) {
			mensaje = "Mesa no registrada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@DeleteMapping("/eliminarMesa")
	@ResponseBody
	public ResultadoResponse eliminarMesa(@RequestBody
			MesaRequest mesaRequest) {
		String mensaje = "Mesa eliminada correctamente :v";
		Boolean respuesta = true;
		try {
			mesaService.eliminarMesa(mesaRequest.getId_mesa());
		}catch (Exception e) {
			mensaje = "Mesa no eliminada";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@GetMapping("/listarMesas")
	@ResponseBody
	public List<MesaModel> listarMesas(){
		return mesaService.listarMesa();
	}

}
