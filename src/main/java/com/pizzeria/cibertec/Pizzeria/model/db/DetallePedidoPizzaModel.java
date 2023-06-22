package com.pizzeria.cibertec.Pizzeria.model.db;

import com.pizzeria.cibertec.Pizzeria.model.PK.DetallePedidoPizzaPK;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@IdClass(DetallePedidoPizzaPK.class)
@Entity
@Table(name = "pedidos_pizzas")
public class DetallePedidoPizzaModel {
    @Id
    private Integer id_pedido;
    @Id
    private Integer id_pizza;
    Integer cantidad;
}
