package com.miniproject.collegeminiproject.Security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf-> csrf.disable())
            .authorizeHttpRequests((configurer) -> configurer
                            .requestMatchers("/addevent.html").hasAnyRole("ADMIN","CLUB")
                            .requestMatchers("/addEvent").hasAnyRole("ADMIN","CLUB")
                            .anyRequest().authenticated()
            )
            .formLogin((form) -> form
                            .loginPage("/login")
                            .permitAll()
            )
            .logout((logout)-> logout.permitAll()
            );
        return http.build();
    }
}