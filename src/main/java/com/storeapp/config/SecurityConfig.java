package com.storeapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // Swagger bleibt nur für Admin sichtbar
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").hasRole("ADMIN")
                        // Alle anderen Endpunkte auch nur für angemeldete Benutzer
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form.permitAll())  // Login-Formular aktivieren
                .rememberMe(remember -> remember.key("uniqueAndSecret")) // Login merken
                .csrf(csrf -> csrf.disable()); // CSRF deaktiviert, damit POST/PUT funktioniert

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance(); // Klartext-Passwort, nur für Tests
    }
}
