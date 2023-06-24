package com.pizzeria.cibertec.Pizzeria.service;

import com.pizzeria.cibertec.Pizzeria.model.db.RolModel;
import com.pizzeria.cibertec.Pizzeria.model.db.UsuarioModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UsuarioDetalleService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("***************EMAIL INGRESADO  :"+email);
        UsuarioModel usuario = usuarioService.buscarUsuarioPorEmail(email);
        return usuarioPorAutenticacion(usuario,obtenerAutorizacionUsuario(usuario.getRoles()));
    }

    private List<GrantedAuthority>
    obtenerAutorizacionUsuario(
            Set<RolModel> listRoles){
        Set<GrantedAuthority> roles =
                new HashSet<GrantedAuthority>();
        for(RolModel rol: listRoles) {
            roles.add(new
                    SimpleGrantedAuthority(rol.getNomrol()));
        }
        List<GrantedAuthority> grantedAuthorities
                = new ArrayList<>(roles);
        return grantedAuthorities;


    }

    private UserDetails usuarioPorAutenticacion(
            UsuarioModel usuario,
            List<GrantedAuthority> authorityList) {
        return new User(usuario.getCorreousuario(),
                usuario.getContraseniausuario(),
                usuario.getActivo(),
                true, true, true, authorityList);
    }
}
