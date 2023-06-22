package com.pizzeria.cibertec.Pizzeria.model.request;
import com.pizzeria.cibertec.Pizzeria.model.db.MesaModel;
import com.pizzeria.cibertec.Pizzeria.model.db.UsuarioModel;
import lombok.Data;
import java.util.Date;

@Data
public class ReservaRequest {
    private Integer idreserva;
    private Date fechareserva;
    private String estadoreserva;
    private UsuarioModel idusuario;
    private MesaModel id_mesa;
}

