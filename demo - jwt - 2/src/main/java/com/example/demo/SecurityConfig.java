package com.example.demo;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


        private final JwtAuthFilter jwtAuthFilter;

        public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
            this.jwtAuthFilter = jwtAuthFilter;
        }

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                    .csrf(csrf -> csrf.disable())
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/api/auth/**",
                                    "/v3/api-docs/**",  // OpenAPI JSON documentation
                                    "/swagger-ui/**",   // Swagger UI resources
                                    "/swagger-ui.html" ,
                                    "/api/auth/**").permitAll() // Allow login/signup
                            .anyRequest().authenticated() // Secure all other endpoints
                    )
                    .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

            return http.build();
        }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(
//                                "/v3/api-docs/**",  // OpenAPI JSON documentation
//                                "/swagger-ui/**",   // Swagger UI resources
//                                "/swagger-ui.html" ,
//                                "/api/auth/**"
//                                // Swagger UI main page
//                        ).permitAll()  // Require authentication
//                        .anyRequest().authenticated()
//                )
//                .formLogin()  // Enable form-based login
//                .and()
//                .httpBasic(); // Enable basic authentication
//
//        return http.build();
//    }


//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .info(new Info().title("My API").version("1.0"))
//                .addSecurityItem(new SecurityRequirement().addList("BasicAuth"))
//                .components(new io.swagger.v3.oas.models.Components()
//                        .addSecuritySchemes("BasicAuth",
//                                new SecurityScheme()
//                                        .name("BasicAuth")
//                                        .type(SecurityScheme.Type.HTTP)
//                                        .scheme("basic")));
//    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("basicAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("basic")) // Basic Auth
                        .addSecuritySchemes("bearerAuth", new SecurityScheme()
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT") // JWT Auth
                        )
                )
                .security(List.of(
                        new SecurityRequirement().addList("basicAuth"),
                        new SecurityRequirement().addList("bearerAuth")
                ));
    }

}
