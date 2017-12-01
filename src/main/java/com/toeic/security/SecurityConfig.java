package com.toeic.security;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.toeic.service.UserService;

import lombok.extern.java.Log;

@Log
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//@Autowired
	//DataSource dataSource;
	
	
	@Inject
	UserService us;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		log.info("security config.............1");
		
		http
		.authorizeRequests()
		//.antMatchers("/login/guest/**").permitAll().
		.antMatchers("/login/**").permitAll();
		//.antMatchers("/login/**").hasRole("MEMBER");
		log.info("security config.............2");
		/*http.formLogin().loginPage("http://127.0.0.1:63342/cordova/www/login.html");*/
		
		http.csrf().disable();
		log.info("security config.............3");
		/*http.logout().logoutUrl("/logout").invalidateHttpSession(true);*/
		
		http.userDetailsService(us);
		log.info("security config.............4");
	}

	/*@Autowired
	 public void configureGlobal(AuthenticationManagerBuilder auth) throws
	 Exception {
	
	 log.info("build Auth global........");
	
	 String query1 = "SELECT mid username, mpw password, true enabled FROM tbl_member where mid = ?";
	
	 String query2 = "SELECT member mid, role_name role FROM tbl_member_roles WHERE member = ?";
	 	
	 auth
	 .jdbcAuthentication()
	 .dataSource(dataSource)
	 .usersByUsernameQuery(query1)
	 .rolePrefix("ROLE_")
	 .authoritiesByUsernameQuery(query2);
	 
	}*/
	
}
