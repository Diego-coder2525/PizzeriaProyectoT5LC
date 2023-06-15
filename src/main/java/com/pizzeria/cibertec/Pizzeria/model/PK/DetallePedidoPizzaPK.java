package com.pizzeria.cibertec.Pizzeria.model.PK;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DetallePedidoPizzaPK implements Serializable {

    private Integer id_pedido;

    private Integer id_pizza;
}
