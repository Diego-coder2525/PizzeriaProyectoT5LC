package com.pizzeria.cibertec.Pizzeria.controller;

import com.pizzeria.cibertec.Pizzeria.model.db.DetallePedidoPizzaModel;
import com.pizzeria.cibertec.Pizzeria.model.db.PedidoModel;
import com.pizzeria.cibertec.Pizzeria.model.db.PizzaModel;
import com.pizzeria.cibertec.Pizzeria.model.db.UsuarioModel;
import com.pizzeria.cibertec.Pizzeria.service.DetallePedidoPizzaService;
import com.pizzeria.cibertec.Pizzeria.service.PedidoService;
import com.pizzeria.cibertec.Pizzeria.service.UsuarioService;
import com.pizzeria.cibertec.Pizzeria.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarritoController {
    @Autowired
    PedidoService pedidoService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    DetallePedidoPizzaService detallePedidoPizzaService;

    @GetMapping("/carrito")
    public String carrito(Model model, HttpServletRequest request) {
        model.addAttribute("pizzasEscogidas",PedidoController.listaPizzasXID);
        model.addAttribute("mensajeCompra","");
        //return "carrito";
        return "carrito";
    }
    @PostMapping("/procesarCompra")
    public String procesarCompra(@RequestParam("cantidad") int[] cantidades, Model model){
        model.addAttribute("mensajeCompra","Gracias por su compra!");
        List<PizzaModel> listaRegistro = PedidoController.listaPizzasXID;
        PedidoController.listaPizzasXID = new ArrayList<PizzaModel>();
        //idUsuario deberia recogerse de la autenticacion, por defecto sera algun id de usuario, PENDIENTE ACTUALIZACION QUE TOME LOS DATOS DE SEGURIDAD
        //usuario puede tener muchos pedidos, pero los pedidos un solo usuario
        Integer idUsuario =usuarioService.buscarUsuarioPorEmail(Util.obtenerEmailAuth()).getId_usuario();
        UsuarioModel usuario = usuarioService.buscarUsuarioXId(idUsuario);
        //
        PedidoModel registroPedido = new PedidoModel();
        registroPedido.setUsuario(usuario);
        registroPedido.setEstado_pedido("REGISTRADO");

        //
        pedidoService.registrarPedido(registroPedido);

        PedidoModel registroPedidoPizza = pedidoService.ultimoPedido();
        //
        for(int i=0;i<listaRegistro.size();i++){
            //Cantidad 14 para testeo, PENDIENTE MANEJAR CANTIDAD EN LA VISTA
            DetallePedidoPizzaModel detallePedidoPizza = new DetallePedidoPizzaModel(registroPedidoPizza.getId_pedido(),listaRegistro.get(i).getId_pizza(),cantidades[i]);
            detallePedidoPizzaService.registrarDPP(detallePedidoPizza);
        }
        return "carrito";
    }

}
