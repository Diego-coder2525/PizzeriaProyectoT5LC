package com.pizzeria.cibertec.Pizzeria.controller;
import com.pizzeria.cibertec.Pizzeria.model.LoginClass;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String inicio(Model model){
        model.addAttribute("loginClass",new LoginClass());
        model.addAttribute("visual",false);
        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute("loginClass") LoginClass loginClass, Model model){
        if(loginClass.getUser().equals("admin") && loginClass.getPassword().equals("123456")){
            return "inicio";
        }
        model.addAttribute("visual",true);
        model.addAttribute("message","Credenciales incorrectas!");
        return "login";
    }
}
