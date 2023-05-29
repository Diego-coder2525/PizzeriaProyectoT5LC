package com.pizzeria.cibertec.Pizzeria.model.request;
import com.pizzeria.cibertec.Pizzeria.model.MesaModel;
import com.pizzeria.cibertec.Pizzeria.model.UsuarioClass;
import lombok.Data;
import java.util.Date;

@Data
public class ReservaRequest {
    private  Integer idreserva;
    private Date fechareserva;
    private String estadoreserva;
    private UsuarioClass idusuario;
    private MesaModel id_mesa;
}

