package com.pizzeria.cibertec.Pizzeria.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "pizzas")
public class PizzaClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pizza;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "precio")
    private Float precio;
}
