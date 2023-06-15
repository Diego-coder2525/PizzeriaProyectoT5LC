package com.pizzeria.cibertec.Pizzeria.service;

import com.pizzeria.cibertec.Pizzeria.model.UsuarioClass;
import com.pizzeria.cibertec.Pizzeria.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    public List<UsuarioClass> listarUsuario(){
		return usuarioRepository.findAll();
	}
    
    public void registrarUsuario (UsuarioClass usuario){
        usuarioRepository.save(usuario);
    }
    public void eliminarUsuario(Integer id_usuario) {
    	usuarioRepository.deleteById(id_usuario);
    }

    public UsuarioClass buscarUsuarioXId(Integer id_usuario){return usuarioRepository.findById(id_usuario).get();}

}
