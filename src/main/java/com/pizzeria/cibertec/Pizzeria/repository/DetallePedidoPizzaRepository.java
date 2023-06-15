package com.pizzeria.cibertec.Pizzeria.repository;

import com.pizzeria.cibertec.Pizzeria.model.DetallePedidoPizza;
import com.pizzeria.cibertec.Pizzeria.model.PK.DetallePedidoPizzaPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoPizzaRepository extends JpaRepository<DetallePedidoPizza, DetallePedidoPizzaPK> {

}
