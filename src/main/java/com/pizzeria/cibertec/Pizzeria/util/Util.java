package com.pizzeria.cibertec.Pizzeria.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class Util {
    public static String obtenerEmailAuth() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Acceder al email del usuario autenticado
        String emailAuth = authentication.getName();
        return emailAuth;
    }
}
