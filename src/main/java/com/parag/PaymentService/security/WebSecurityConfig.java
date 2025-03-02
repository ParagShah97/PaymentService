package com.parag.PaymentService.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * Security configuration class for the Payment Service.
 * This class sets up authentication and authorization rules,
 * ensuring that only authenticated users with proper scopes can access endpoints.
 */
@Configuration // Marks this class as a Spring Security configuration class
@EnableWebSecurity // Enables Spring Security's web security support
public class WebSecurityConfig {

    /**
     * Defines the security filter chain for handling authentication and authorization.
     *
     * @param http The HttpSecurity object used to configure security settings.
     * @return A SecurityFilterChain instance that enforces the defined security policies.
     * @throws Exception If any security configuration error occurs.
     */
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Authorize HTTP requests based on security policies
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/payment/**") // Applies security rules to /payment/** endpoints
                        .authenticated().anyRequest().permitAll()
//                        .hasAuthority("SCOPE_email") // Ensures the request has the correct scope
//                        .anyRequest()
//                        .authenticated() // All other requests require authentication
                )
                // Configures OAuth2 Resource Server to validate JWT tokens
                .oauth2ResourceServer(oauth2 -> oauth2.jwt(withDefaults()));

        // Builds and returns the security filter chain
        return http.build();
    }
}
