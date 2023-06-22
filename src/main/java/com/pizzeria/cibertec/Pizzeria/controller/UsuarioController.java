package com.pizzeria.cibertec.Pizzeria.controller;

import com.pizzeria.cibertec.Pizzeria.model.db.UsuarioModel;
import com.pizzeria.cibertec.Pizzeria.model.response.ResultadoResponse;
import com.pizzeria.cibertec.Pizzeria.service.UsuarioService;

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

import com.pizzeria.cibertec.Pizzeria.model.request.*;


import java.util.Date;
import java.util.Calendar;
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/frmusuario")
	public String frmMantSala(Model model) {
		model.addAttribute("listausuarios", 
				usuarioService.listarUsuario());
		return "usuario/frmusuario";
	}
	
	@PostMapping("/registrarUsuario")
	@ResponseBody
	public ResultadoResponse registrarUsuario(
			@RequestBody UsuarioRequest usuarioRequest
			) {
		String mensaje ="Usuario registrado correctamente";
		Boolean respuesta = true;
		try {			

			UsuarioModel objUsu = new UsuarioModel();
			if(usuarioRequest.getId_usuario() > 0) {
				objUsu.setId_usuario(usuarioRequest.getId_usuario());
			}
			objUsu.setNombreusuario(usuarioRequest.getNombre_usuario());
			objUsu.setCorreousuario(usuarioRequest.getCorreo_usuario());
			objUsu.setContraseniausuario(usuarioRequest.getContrasenia_usuario());
			 Date fechaActual = Calendar.getInstance().getTime();
		        objUsu.setFecha_registro(fechaActual);
			usuarioService.registrarUsuario(objUsu);
		}catch(Exception ex) {
			mensaje = "Usuario no registrad";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@DeleteMapping("/eliminarUsuario")
	@ResponseBody
	public ResultadoResponse eliminarUsuario(@RequestBody
			UsuarioRequest usuarioRequest) {
		String mensaje = "Usuario eliminado correctamente";
		Boolean respuesta = true;
		try {
			usuarioService.eliminarUsuario(usuarioRequest.getId_usuario());
		}catch (Exception e) {
			mensaje = "Usuario no eliminado";
			respuesta = false;
		}
		return ResultadoResponse.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@GetMapping("/listarUsuarios")
	@ResponseBody
	public List<UsuarioModel> listarUsuarios(){
		return usuarioService.listarUsuario();
	}
	
	
	
	

}
