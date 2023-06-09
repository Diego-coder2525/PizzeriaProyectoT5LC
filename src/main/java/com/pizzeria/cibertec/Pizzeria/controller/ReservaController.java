package com.pizzeria.cibertec.Pizzeria.controller;


import com.pizzeria.cibertec.Pizzeria.model.MesaModel;
import com.pizzeria.cibertec.Pizzeria.model.ReservaModel;
import com.pizzeria.cibertec.Pizzeria.model.UsuarioClass;
import com.pizzeria.cibertec.Pizzeria.model.request.ReservaRequest;
import com.pizzeria.cibertec.Pizzeria.model.response.ResultadoResponse;
import com.pizzeria.cibertec.Pizzeria.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ReservaController {

    @Autowired
    private ReservaService reservaService;
    //ReservaRequest reservaRequest;



    @GetMapping("/frmreserva")
    public String frmMantReserva(Model model) {
        model.addAttribute("listareservas",
                reservaService.listarReserva());
        return "reserva/frmreserva";
    }

    @PostMapping("/registrarReserva")
    @ResponseBody
    public ResultadoResponse registrarReserva(@RequestBody ReservaRequest reservaRequest)
    {
        String mensaje ="Reserva registrada correctamente";
        Boolean respuesta = true;
        try {
            ReservaModel objReserva = new ReservaModel();
            if(reservaRequest.getIdreserva() > 0) {
                objReserva.setId_reserva(reservaRequest.getIdreserva());
            }

                objReserva.setFechareserva(reservaRequest.getFechareserva());
                objReserva.setEstadoreserva(reservaRequest.getEstadoreserva());
                UsuarioClass objUsuario = new UsuarioClass();
                    objUsuario.setId_usuario(reservaRequest.getIdusuario().getId_usuario());
                MesaModel objMesa = new MesaModel();
                    objMesa.setId_mesa(reservaRequest.getId_mesa().getId_mesa());
                reservaService.registrarReserva(objReserva);
            }catch(Exception ex) {
                mensaje = "Reserva no registrada";
                respuesta = false;
        }
            return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta)
                .build();
    }

    @DeleteMapping("/eliminarReserva")
    @ResponseBody
    public ResultadoResponse eliminarReserva(@RequestBody ReservaRequest reservaRequest) {
        String mensaje = "Reserva eliminada correctamente";
        boolean respuesta = true;
        try {
            reservaService.eliminarReserva(reservaRequest.getIdreserva());
        }catch (Exception e) {
            mensaje = "Reserva no eliminada";
            respuesta = false;
        }
        return ResultadoResponse.builder()
                .mensaje(mensaje)
                .respuesta(respuesta)
                .build();
    }
    @GetMapping("/listarReservas")
    @ResponseBody
    public List<ReservaModel> listarReservas(){
        return reservaService.listarReserva();
    }
}
