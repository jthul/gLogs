package org.gLogs.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
/**
 * 
 *  SecurityConfiguration is a configuration anotation class
 *  It allow us to configure how the security will work into the app
 *  
 * @author thulliezj
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*
	 * TODO : Change this way of connecting to the database one
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.inMemoryAuthentication().withUser("toto").password("toto").roles("USER");
	  auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
	  auth.inMemoryAuthentication().withUser("dba").password("dba").roles("DBA");
	}
	
	/*
	 * Method of auth mapping
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/serverStatus").access("hasRole('ROLE_ADMIN')")
		.and().formLogin().loginPage("/login.do").permitAll();
	}
}
