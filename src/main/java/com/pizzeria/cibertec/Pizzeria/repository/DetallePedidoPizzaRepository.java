package com.pizzeria.cibertec.Pizzeria.repository;

import com.pizzeria.cibertec.Pizzeria.model.db.DetallePedidoPizzaModel;
import com.pizzeria.cibertec.Pizzeria.model.PK.DetallePedidoPizzaPK;
import com.pizzeria.cibertec.Pizzeria.model.response.HistorialQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DetallePedidoPizzaRepository extends JpaRepository<DetallePedidoPizzaModel, DetallePedidoPizzaPK> {

    @Query(
            value = "SELECT new com.pizzeria.cibertec.Pizzeria.model.response.HistorialQuery(p.id_pedido, u.nombreusuario,p.fecha_pedido,p.estado_pedido,pp.cantidad,pz.nombre,pz.descripcion,pz.precio) FROM PedidoModel p JOIN UsuarioModel u ON p.usuario.id_usuario=u.id_usuario JOIN DetallePedidoPizzaModel pp ON p.id_pedido=pp.id_pedido JOIN PizzaModel pz ON pp.id_pizza=pz.id_pizza WHERE u.id_usuario = ?1"
    )
    List<HistorialQuery> ejecutarConsultaCompleja(Integer idUsuario);
}

