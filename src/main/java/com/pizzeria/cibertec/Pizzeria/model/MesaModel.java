package com.pizzeria.cibertec.Pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="mesas")
public class MesaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_mesa;
    @Column(name="capacidad")
	private Integer capacidad;
    @Column(name="disponible")
	private Boolean disponible;
}
