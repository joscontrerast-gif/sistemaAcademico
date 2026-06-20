package com.saie.asistencia.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())  // 🔥 CLAVE PARA POST
                .authorizeHttpRequests(auth -> auth

                        // 🔓 permitir asistencia
                        .requestMatchers("/api/asistencias/**").permitAll()

                        // 🔓 auth
                        .requestMatchers("/auth/**").permitAll()

                        // resto protegido
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}