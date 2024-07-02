package com.charlottewiltshire0.updaterinstaller.api.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
class SecurityConfig(
    private val userDetailsService: UserDetailsService
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests { authz ->
                authz
                    .requestMatchers(HttpMethod.POST, "/api/v1/users").hasAnyRole("ADMIN","SUPERADMIN")
                    .requestMatchers(HttpMethod.PATCH, "/api/v1/users/{id}").hasRole( "SUPERADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/api/v1/users/{id}").hasRole("SUPERADMIN")
                    .requestMatchers(HttpMethod.GET, "/api/v1/users/{id}").hasAnyRole("ADMIN", "SUPERADMIN")
                    .anyRequest().authenticated()
            }
            .formLogin { login ->
                login
                    .permitAll()
            }
            .logout { logout ->
                logout
                    .permitAll()
            }
        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()

    @Bean
    fun authManager(authConfig: AuthenticationConfiguration) = authConfig.authenticationManager
}