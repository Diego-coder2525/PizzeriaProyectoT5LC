package com.pizzeria.cibertec.Pizzeria.model.db;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="rol")
public class RolModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrol;
    @Column(name = "nomrol")
    private String nomrol;
}
