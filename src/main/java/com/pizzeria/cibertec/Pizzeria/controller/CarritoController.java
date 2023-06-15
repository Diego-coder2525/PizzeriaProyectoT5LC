package com.pizzeria.cibertec.Pizzeria.controller;

import com.pizzeria.cibertec.Pizzeria.constant.Constant;
import com.pizzeria.cibertec.Pizzeria.model.DetallePedidoPizza;
import com.pizzeria.cibertec.Pizzeria.model.PedidoModel;
import com.pizzeria.cibertec.Pizzeria.model.PizzaClass;
import com.pizzeria.cibertec.Pizzeria.model.UsuarioClass;
import com.pizzeria.cibertec.Pizzeria.service.DetallePedidoPizzaService;
import com.pizzeria.cibertec.Pizzeria.service.PedidoService;
import com.pizzeria.cibertec.Pizzeria.service.PizzaService;
import com.pizzeria.cibertec.Pizzeria.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String procesarCompra(Model model){
        model.addAttribute("mensajeCompra","Gracias por su compra!");
        List<PizzaClass> listaRegistro = PedidoController.listaPizzasXID;
        PedidoController.listaPizzasXID = new ArrayList<PizzaClass>();
        //idUsuario deberia recogerse de la autenticacion, por defecto sera 6 <- admin por ahora, PENDIENTE ACTUALIZACION QUE TOME LOS DATOS DE SEGURIDAD
        //usuario puede tener muchos pedidos, pero los pedidos un solo usuario
        Integer idUsuario = 6;
        UsuarioClass usuario = usuarioService.buscarUsuarioXId(idUsuario);
        PedidoModel registroPedido = new PedidoModel();
        registroPedido.setUsuario(usuario);
        registroPedido.setEstado_pedido("REGISTRADO");
        pedidoService.registrarPedido(registroPedido);

        PedidoModel registroPedidoPizza = pedidoService.ultimoPedido();
        //
        for(int i=0;i<listaRegistro.size();i++){
            //Cantidad 14 para testeo, PENDIENTE MANEJAR CANTIDAD EN LA VISTA
            DetallePedidoPizza detallePedidoPizza = new DetallePedidoPizza(registroPedidoPizza.getId_pedido(),listaRegistro.get(i).getId_pizza(),14);
            detallePedidoPizzaService.registrarDPP(detallePedidoPizza);
        }

        return "carrito";
    }

}
