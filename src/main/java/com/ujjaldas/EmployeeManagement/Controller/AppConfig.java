package com.ujjaldas.EmployeeManagement.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AppConfig {

	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
		UserDetails virat = User.builder()
				.username("virat")
				.password("{noop}v")
				.roles("EMPLOYEE")
				.build();
				
		UserDetails rohit = User.builder()
				.username("rohit")
				.password("{noop}r")
				.roles("MANAGER")
				.build();
		
		UserDetails dhoni = User.builder()
				.username("dhoni")
				.password("{noop}d")
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(virat,rohit,dhoni);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
		.authorizeHttpRequests(
				(configurer) -> configurer
				.anyRequest()
				.authenticated()
				)
		
		.formLogin(
				form -> form.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
				);
		
		return http.build();
		
	}
	
}
