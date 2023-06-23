package com.pizzeria.cibertec.Pizzeria.repository;

import com.pizzeria.cibertec.Pizzeria.model.db.UsuarioModel;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository 
extends JpaRepository<UsuarioModel, Integer> {
    //Buscar usuario por id
    //UsuarioClass findById_usuario(Integer id_usuario); <-- fracaso
    UsuarioModel findByCorreousuario(String email);

    UsuarioModel findBynombreusuario(String username);


}
