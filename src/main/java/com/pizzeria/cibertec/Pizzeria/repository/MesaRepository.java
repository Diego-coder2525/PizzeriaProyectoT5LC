package com.pizzeria.cibertec.Pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pizzeria.cibertec.Pizzeria.model.db.MesaModel;

@Repository
public interface MesaRepository extends JpaRepository<MesaModel, Integer> {

}
