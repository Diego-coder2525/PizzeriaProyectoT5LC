package com.pizzeria.cibertec.Pizzeria.model.request;
import com.pizzeria.cibertec.Pizzeria.model.db.MesaModel;
import com.pizzeria.cibertec.Pizzeria.model.db.UsuarioModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class ReservaRequest {
    private int idreserva;
    private Date fechareserva;
    private String estadoreserva;
    private int idusuario;
    private int id_mesa;

    public ReservaRequest(int idreserva, Date fechareserva, String estadoreserva, int idusuario, int id_mesa) {
        this.idreserva = idreserva;
        this.fechareserva = fechareserva;
        this.estadoreserva = estadoreserva;
        this.idusuario = idusuario;
        this.id_mesa = id_mesa;
    }
}

