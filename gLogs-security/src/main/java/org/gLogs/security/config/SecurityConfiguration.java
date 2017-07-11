package org.gLogs.security.config;

import org.gLogs.security.service.NitriteUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

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
public class SecurityConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private NitriteUserDetailsService nitriteUserDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(nitriteUserDetailsService);
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore()).accessTokenConverter(accessTokenConverter())
				.userDetailsService(nitriteUserDetailsService);
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("123");
		return converter;
	}

	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		defaultTokenServices.setSupportRefreshToken(true);
		return defaultTokenServices;
	}

	public NitriteUserDetailsService getNitriteUserDetailsService() {
		return nitriteUserDetailsService;
	}

	public void setNitriteUserDetailsService(NitriteUserDetailsService nitriteUserDetailsService) {
		this.nitriteUserDetailsService = nitriteUserDetailsService;
	}

}
