package com.pizzeria.cibertec.Pizzeria.constant;

import com.pizzeria.cibertec.Pizzeria.model.db.RolModel;
import com.pizzeria.cibertec.Pizzeria.model.db.UsuarioModel;
import com.pizzeria.cibertec.Pizzeria.repository.RolRepository;
import com.pizzeria.cibertec.Pizzeria.repository.UsuarioRepository;
import com.pizzeria.cibertec.Pizzeria.service.UsuarioService;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.HashSet;

public class EncriptPassword {


    public static void main(String[] args){
        UsuarioService usuarioService = new UsuarioService();
        RolRepository rolRepository;
        var password ="123";
        System.out.println("password : " +password);
        System.out.println("pass encriptado : "+encriptarPassword(password));
        UsuarioModel usuarioModel = new UsuarioModel(
                null,
                "jose",
                "jose@jose.com",
                "jose123",
                null,
                true,
                new HashSet<RolModel>()
        );
    }


        public static String encriptarPassword(String password){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            return encoder.encode(password);
        }


}
