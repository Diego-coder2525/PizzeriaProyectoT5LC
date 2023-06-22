package com.pizzeria.cibertec.Pizzeria.repository;

import com.pizzeria.cibertec.Pizzeria.model.db.RolModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<RolModel,Integer> {
    RolModel findByNomrol(String rolname);
}
