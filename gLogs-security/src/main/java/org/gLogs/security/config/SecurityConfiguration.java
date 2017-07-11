package org.gLogs.security.config;

import org.gLogs.security.service.NitriteUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * 
 * SecurityConfiguration is a configuration anotation class It allow us to
 * configure how the security will work into the app
 * 
 * @author thulliezj
 *
 */
@Configuration
@EnableAuthorizationServer
@ComponentScan({ "org.gLogs.security.service" })
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private NitriteUserDetailsService nitriteUserDetailsService;

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/user/authenticate");
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	    auth.userDetailsService(nitriteUserDetailsService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().fullyAuthenticated().and()
				.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class).httpBasic().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();
	}

	public NitriteUserDetailsService getNitriteUserDetailsService() {
		return nitriteUserDetailsService;
	}

	public void setNitriteUserDetailsService(NitriteUserDetailsService nitriteUserDetailsService) {
		this.nitriteUserDetailsService = nitriteUserDetailsService;
	}

}
