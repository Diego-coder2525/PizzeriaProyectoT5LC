package com.pizzeria.cibertec.Pizzeria.request;

import lombok.Data;


@Data
public class PizzaRequest {
    private Integer id_pizza;

    private String nombre;

    private String descripcion;

    private Float precio;
}
