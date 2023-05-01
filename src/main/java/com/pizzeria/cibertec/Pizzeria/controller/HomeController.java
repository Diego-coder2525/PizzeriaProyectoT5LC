package com.pizzeria.cibertec.Pizzeria.controller;

import com.pizzeria.cibertec.Pizzeria.constant.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

// Controlador rest para prueba rapida
// @RestController
@Controller
public class HomeController{
    // Padre del @GetMapping
        /*@RequestMapping("/home")
        public String home(){
            return "ASDADSASDASDDASADASDDDDDDDDDDDD";
        }*/
    private void autenticacion(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        if(session.getAttribute("sessionClose")!=null){
            model.addAttribute("userLog",session.getAttribute("userLog"));

        }else{
            Constant.usuarioVigente=null;
            session.setAttribute("userLog",Constant.usuarioVigente);
            model.addAttribute("userLog",session.getAttribute("userLog"));
        }
    }

    @GetMapping("/inicio")
    public String inicio(Model model, HttpServletRequest request) {
        //System.out.println("SESIOOOOOOOOOOOOOONCLOSE:"+session.getAttribute("sessionClose"));
        //System.out.println("SESIOOOOOOOOOOOOOONCLOSE:"+session.getAttribute("userLog"));
        autenticacion(model,request);
        //System.out.println("USERLOOOOOOOG: "+model.getAttribute("userLog"));
        return "inicio";
    }

    @GetMapping("/reservas")
    public String reservas(Model model, HttpServletRequest request) {
        autenticacion(model,request);
        return "reservas";
    }

    @GetMapping("/pedidos")
    public String pedidos(Model model, HttpServletRequest request) {
        autenticacion(model,request);
        return "pedidos";
    }
    @GetMapping("/historial")
    public String historial(Model model, HttpServletRequest request) {

        autenticacion(model,request);
        return "historial";
    }
    @GetMapping("/contacto")
    public String contacto(Model model, HttpServletRequest request) {
        autenticacion(model,request);
        return "contacto";
    }
    @GetMapping("/carrito")
    public String carrito(Model model, HttpServletRequest request) {
        autenticacion(model,request);
        return "carrito";
    }
}
