package com.pizzeria.cibertec.Pizzeria.model.request;

import lombok.Data;
import java.util.Date;

@Data
public class UsuarioRequest {
	private Integer id_usuario;
	private String nombre_usuario;
	private String correo_usuario;
	private String contrasenia_usuario;
	private Date fecha_registro;
}
