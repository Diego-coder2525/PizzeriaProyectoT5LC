package com.pizzeria.cibertec.Pizzeria.configuration;

import com.pizzeria.cibertec.Pizzeria.service.UsuarioDetalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    @Autowired
    private final UsuarioDetalleService userDetailService;

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws  Exception{
        http
                .authorizeHttpRequests()
                .antMatchers("/auth/login",
                        "/auth/register",
                        "/auth/saveUser",
                        "/resources/**",
                        "/static/**",
                        "/css/**",
                        "/js/**",
                        "/imgs/**",
                        "index.html")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/auth/login")
                .usernameParameter("correousuario")
                .passwordParameter("contraseniausuario")
                .defaultSuccessUrl("/")
                .failureUrl("/auth/login?error=true")
                .and()
                .sessionManagement(session ->session  //apartir de aqui se implementa  para la session
                        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                        .invalidSessionUrl("/auth/login?logout=true")
                        .maximumSessions(1)
                        .maxSessionsPreventsLogin(false))
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/auth/login?logout=invalid").and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied")
                .and()
                .authenticationProvider(
                        authenticationProvider());
        return http.build();
    }

    @Bean
    public AuthenticationProvider
    authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider
                = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(
                userDetailService);
        authenticationProvider.setPasswordEncoder(
                new BCryptPasswordEncoder());
        return authenticationProvider;
    }

}
