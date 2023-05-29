package com.pizzeria.cibertec.Pizzeria.repository;

import com.pizzeria.cibertec.Pizzeria.model.PizzaClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRespository extends JpaRepository<PizzaClass, Integer> {
}
