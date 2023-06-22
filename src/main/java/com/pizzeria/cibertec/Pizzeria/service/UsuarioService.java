package com.pizzeria.cibertec.Pizzeria.service;

import com.pizzeria.cibertec.Pizzeria.model.db.RolModel;
import com.pizzeria.cibertec.Pizzeria.model.db.UsuarioModel;
import com.pizzeria.cibertec.Pizzeria.repository.RolRepository;
import com.pizzeria.cibertec.Pizzeria.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RolRepository rolRepository;

    public List<UsuarioModel> listarUsuario(){
		return usuarioRepository.findAll();
	}

    public void registrarUsuario (UsuarioModel usuario){
        usuarioRepository.save(usuario);
    }
    public void eliminarUsuario(Integer id_usuario) {
    	usuarioRepository.deleteById(id_usuario);
    }
    public UsuarioModel buscarUsuarioXId(Integer idUsuario) {
        Optional<UsuarioModel> usuarioOptional = usuarioRepository.findById(idUsuario);
        return usuarioOptional.orElse(null);
    }

    public UsuarioModel buscarUsuarioporEmail(String username){
        return usuarioRepository.findBycorreousuario(username);
    }


    public void guardarUsuario(UsuarioModel usuario) {
        usuario.setContraseniausuario(encriptarPassword(usuario.getContraseniausuario()));
        usuario.setActivo(true);
        RolModel rol = rolRepository.findByNomrol("ADMIN");
        usuario.setRoles(new HashSet<RolModel>(Collections.singletonList(rol)));
        usuarioRepository.save(usuario);
    }

    public static String encriptarPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

}
