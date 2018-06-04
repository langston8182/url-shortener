package com.notarius.urlshortener.urlshortener.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.notarius.urlshortener.urlshortener.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private UserService userService;
	
	@Autowired
	public SecurityConfig(UserService userService) {
		super();
		this.userService = userService;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	public void configureGlobale(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/url/**").hasRole("ADMIN")
			.antMatchers("/**").permitAll()
			
			.and()
			.formLogin()
			.loginPage("/login")
			.defaultSuccessUrl("/url/encode", true)
			.failureUrl("/login?error=true")
			
			.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/login?logout=true");
	}
	
}
