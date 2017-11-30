package com.toeic.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.java.Log;

@Log
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		log.info("security config.............");
		
		http
		.authorizeRequests()
		.antMatchers("/login/guest/**").hasRole("MEMBER").
		antMatchers("/login/manager/**").permitAll();
		
		http.csrf().disable();
		
	}

//	 @Autowired
//	 public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	
//	 log.info("build Auth global........");
//	
//	 auth.inMemoryAuthentication().withUser("manager").password("1111").roles("MANAGER");
//	 }
}
