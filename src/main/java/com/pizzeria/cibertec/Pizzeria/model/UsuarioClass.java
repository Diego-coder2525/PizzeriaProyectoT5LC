package com.pizzeria.cibertec.Pizzeria.model;

import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "usuarios")
public class UsuarioClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(name = "nombre")
    private String nombre_usuario;

    @Column(name = "correo_electronico")
    private String correo_usuario;

    @Column(name = "contrasenia")
    private String contrasenia_usuario;

    @Column(name = "fecha_registro")
    private Date fecha_registro;

}
