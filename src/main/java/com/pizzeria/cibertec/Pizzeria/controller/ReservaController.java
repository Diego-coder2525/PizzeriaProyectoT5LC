package com.pizzeria.cibertec.Pizzeria.controller;


import com.pizzeria.cibertec.Pizzeria.model.db.MesaModel;
import com.pizzeria.cibertec.Pizzeria.model.db.ReservaModel;
import com.pizzeria.cibertec.Pizzeria.model.db.UsuarioModel;
import com.pizzeria.cibertec.Pizzeria.model.request.ReservaRequest;
import com.pizzeria.cibertec.Pizzeria.model.response.ResultadoResponse;
import com.pizzeria.cibertec.Pizzeria.service.MesaService;
import com.pizzeria.cibertec.Pizzeria.service.ReservaService;
import com.pizzeria.cibertec.Pizzeria.service.UsuarioService;
import com.pizzeria.cibertec.Pizzeria.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;
    @Autowired
    private MesaService mesaService;
    //ReservaRequest reservaRequest;
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/reserva")
    public String frmMantReserva(Model model) {
        model.addAttribute( "listareservas",
                reservaService.listarReserva());
        return "reserva/frmreserva";
    }

    @GetMapping("/booking")
    public String frmMantBooking(Model model) {
        model.addAttribute("listareservas",reservaService.listarReserva());
        //String emailAuth = Util.obtenerEmailAuth();
        //int id_usuario = usuarioService.buscarUsuarioPorEmail(emailAuth).getId_usuario();
        //List<ReservaRequest> lreserva= reservaService.listarReservaID(id_usuario);
        //model.addAttribute("listareservas",lreserva);
        model.addAttribute("listarmesas",mesaService.listarMesa());
        return "reserva/booking";
    }

    @PostMapping("/saveBooking")
    public String saveBooking (@ModelAttribute ReservaModel reserva, Model model){
        reservaService.registrarReserva(reserva);
        model.addAttribute("registro Correcto",true);
        model.addAttribute( "listareservas",reservaService.listarReserva());
        return "reserva/booking";
    }


    @DeleteMapping("/eliminarReserva")
    @ResponseBody
    public ResultadoResponse eliminarReserva(@RequestBody ReservaRequest reservaRequest) {
        String mensaje = "Reserva eliminada correctamente";
        Boolean respuesta = true;
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

    //ESTE SI SALE
    @GetMapping("/listarReservas")
    @ResponseBody
    public List<ReservaModel> listarReservas(){
        return reservaService.listarReserva();
    }
}