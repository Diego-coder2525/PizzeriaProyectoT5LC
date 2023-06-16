package com.pizzeria.cibertec.Pizzeria.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class HistorialQuery {

        private Integer idPedido;
        private String nombreUsuario;
        private Date fechaPedido;
        private String estadoPedido;
        private Integer cantidad;
        private String nombrePizza;
        private String descripcionPizza;
        private Float precioPizza;

        // Constructor, getters y setters
        public HistorialQuery(Integer id, String nombre, Date fecha, String estado, Integer cantidad, String nombrePizza, String descripcionPizza, Float precioPizza) {
                // Inicializa los atributos de la clase con los parámetros recibidos
                this.idPedido = id;
                this.nombreUsuario = nombre;
                this.fechaPedido = fecha;
                this.estadoPedido = estado;
                this.cantidad = cantidad;
                this.nombrePizza = nombrePizza;
                this.descripcionPizza = descripcionPizza;
                this.precioPizza = precioPizza;
        }


}
