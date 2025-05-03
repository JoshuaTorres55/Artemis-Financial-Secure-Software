package com.snhu.sslserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Disable CSRF for demonstration (update as needed)
            .headers(headers -> headers.contentSecurityPolicy("script-src 'self'"))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(new AntPathRequestMatcher("/hash"), new AntPathRequestMatcher("/checksum")).permitAll()
                .anyRequest().authenticated()
            );
        return http.build();
    }
}
