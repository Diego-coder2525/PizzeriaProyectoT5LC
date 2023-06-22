package com.pizzeria.cibertec.Pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pizzeria.cibertec.Pizzeria.model.db.PedidoModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Integer> {

        @Query(value = "SELECT * FROM pedidos ORDER BY id_pedido DESC LIMIT 1", nativeQuery = true)
        PedidoModel obtenerUltimoRegistro();

    }


