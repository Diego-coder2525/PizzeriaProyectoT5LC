package com.pizzeria.cibertec.Pizzeria.repository;


import com.pizzeria.cibertec.Pizzeria.model.ReservaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaModel,Integer> {
}
