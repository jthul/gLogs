package org.gLogs.security.config;

import org.gLogs.security.service.NitriteUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
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
@ComponentScan({"org.gLogs.security.service"})
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private NitriteUserDetailsService nitriteUserDetailsService;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	  auth.userDetailsService(nitriteUserDetailsService);
	}
	
	/*
	 * Method of auth mapping
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/serverStatus").permitAll()
		.antMatchers("/designer/**").access("hasRole('ROLE_ADMIN')")
		.and().formLogin().loginPage("/login.do")
		.permitAll().defaultSuccessUrl("/designer", false);
	}
	
	/* Setter */

	public NitriteUserDetailsService getNitriteUserDetailsService() {
		return nitriteUserDetailsService;
	}

	public void setNitriteUserDetailsService(NitriteUserDetailsService nitriteUserDetailsService) {
		this.nitriteUserDetailsService = nitriteUserDetailsService;
	}
	
	
}
