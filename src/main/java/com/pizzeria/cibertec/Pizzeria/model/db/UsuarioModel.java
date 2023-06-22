package com.pizzeria.cibertec.Pizzeria.model.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuarios")
public class UsuarioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_usuario;

    @Column(name = "nombre")
    private String nombreusuario;


    @Column(name = "correo_electronico")
    private String correousuario;

    @Column(name = "contrasenia")
    private String contraseniausuario;

    @Column(name = "fecha_registro")
    private Date fecha_registro;

    @Column(name = "activo")
    private Boolean activo;

    @ManyToMany(cascade = CascadeType.MERGE,
            fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "idrol"))
    private Set<RolModel> roles;
}
