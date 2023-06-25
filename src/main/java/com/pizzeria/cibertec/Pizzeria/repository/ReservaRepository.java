package com.pizzeria.cibertec.Pizzeria.repository;


import com.pizzeria.cibertec.Pizzeria.model.db.ReservaModel;
import com.pizzeria.cibertec.Pizzeria.model.db.UsuarioModel;
import com.pizzeria.cibertec.Pizzeria.model.request.ReservaRequest;
import com.pizzeria.cibertec.Pizzeria.model.response.HistorialQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<ReservaModel,Integer> {



    @Query(
            value = "SELECT new com.pizzeria.cibertec.Pizzeria.model.request.ReservaRequest(r.id_reserva,r.fechareserva,r.estadoreserva,u.id_usuario,m.id_mesa)FROM ReservaModel r JOIN UsuarioModel u ON r.idusuario.id_usuario = u.id_usuario JOIN MesaModel m ON r.idmesa.id_mesa = m.id_mesa WHERE u.id_usuario = ?1"
    )
    List<ReservaRequest> ejecutarConsultaCompleja(Integer idUsuario);

}
