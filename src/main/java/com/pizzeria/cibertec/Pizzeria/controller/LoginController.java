package com.pizzeria.cibertec.Pizzeria.controller;
import com.pizzeria.cibertec.Pizzeria.constant.Constant;
import com.pizzeria.cibertec.Pizzeria.model.LoginClass;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String inicio(Model model, HttpSession session){
        model.addAttribute("loginClass",new LoginClass());
        model.addAttribute("visual",false);
        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("loginClass") LoginClass loginClass, Model model, HttpSession session){
        //Pendiente a modificar el login y a detectar la correcta entrada de datos, implementando el uso de la bd
        if(loginClass.getUser().equals("admin") && loginClass.getPassword().equals("123456")){
            session.setAttribute("sessionClose",false);

            Constant.usuarioVigente="admin";
            session.setAttribute("userLog",Constant.usuarioVigente);
            return "redirect:/inicio";
        }
        //
        model.addAttribute("visual",true);
        model.addAttribute("message","Credenciales incorrectas!");
        return "login";
    }

    @GetMapping("/cerrar")
    public String cerrar(HttpSession session){
        session.setAttribute("sessionClose",null);
        return "redirect:/inicio";
    }

}
