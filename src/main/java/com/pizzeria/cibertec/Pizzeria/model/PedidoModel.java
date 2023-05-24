package com.pizzeria.cibertec.Pizzeria.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="pedidos")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pedido;
    @Column(name="id_usuario")
	private Integer id_usuario;
    @Column(name="fecha_pedido")
	private Date fecha_pedido;
    @Column(name="estado_pedido")
	private String estado_pedido;
	
}
