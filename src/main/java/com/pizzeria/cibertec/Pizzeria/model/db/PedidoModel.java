package com.pizzeria.cibertec.Pizzeria.model.db;



import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="pedidos")
public class PedidoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pedido;


    @ManyToOne
    @JoinColumn(name = "id_usuario")
	private UsuarioModel usuario;


    @Column(name="fecha_pedido")
	private Date fecha_pedido;

    @Column(name="estado_pedido")
	private String estado_pedido;
    @PrePersist
    protected void onCreate() {
        fecha_pedido = new Date();
    }
}
