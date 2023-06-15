package com.pizzeria.cibertec.Pizzeria.repository;

import com.pizzeria.cibertec.Pizzeria.model.UsuarioClass;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository 
extends JpaRepository<UsuarioClass, Integer> {
    //Buscar usuario por id
    //UsuarioClass findById_usuario(Integer id_usuario); <-- fracaso
}
