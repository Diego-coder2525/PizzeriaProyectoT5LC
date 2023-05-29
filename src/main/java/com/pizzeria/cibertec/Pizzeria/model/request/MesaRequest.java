package com.pizzeria.cibertec.Pizzeria.model.request;

import lombok.Data;

@Data
public class MesaRequest {
	private Integer id_mesa;
	private Integer capacidad;
	private Boolean disponible;
}
