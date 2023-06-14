package com.pizzeria.cibertec.Pizzeria.model;



import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

@Entity
@Data
@Table(name="pedidos")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pedido;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_usuario")
	private UsuarioClass usuario;


    @Column(name="fecha_pedido")
	private Date fecha_pedido;
    @Column(name="estado_pedido")
	private String estado_pedido;
	
}
