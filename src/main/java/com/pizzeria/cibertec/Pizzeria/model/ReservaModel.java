package com.pizzeria.cibertec.Pizzeria.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table (name = "reservas")
public class ReservaModel {
    /*
    *     id_reserva INT PRIMARY KEY AUTO_INCREMENT,
    id_usuario INT NOT NULL,
    id_mesa INT NOT NULL,
    fecha_reserva DATETIME NOT NULL,
    estado_reserva VARCHAR(20) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario),
    FOREIGN KEY (id_mesa) REFERENCES mesas(id_mesa)
    *
        * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_reserva;
    @Column(name = "fecha_reserva")
    private Date fechareserva;
    @Column(name="estado_reserva")
    private String estadoreserva;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioClass idusuario;

    @ManyToOne
    @JoinColumn(name = "id_mesa")
    private MesaModel idmesa;



}
