package com.ujjaldas.EmployeeManagement.Controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class AppConfig {


    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10); 
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(
                (configurer) -> configurer
                    .requestMatchers("/api/roles/**").hasRole("ADMIN")
                    .requestMatchers("/api/users/**").hasRole("ADMIN")
                    .requestMatchers("/api/employees/**").hasAnyRole("ADMIN", "MANAGER", "EMPLOYEE")
                    .requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole("ADMIN", "MANAGER", "EMPLOYEE")
                    .requestMatchers(HttpMethod.POST, "/api/employees").hasAnyRole("ADMIN", "MANAGER")
                    .requestMatchers(HttpMethod.PUT, "/api/employees/**").hasAnyRole("ADMIN", "MANAGER")
                    .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
            )
            .formLogin(
                form -> form
                    .loginPage("/login")
                    .loginProcessingUrl("/authenticateTheUser")
                    .permitAll()
            )
            .logout(
                logout -> logout
                    .logoutSuccessUrl("/login?logout")
                    .permitAll()
            );

        return http.build();
    }



}
