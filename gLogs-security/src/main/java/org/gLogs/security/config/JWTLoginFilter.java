package org.gLogs.security.config;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Represent the filter called when trying to access to '/login' 
 * 
 * @author jThulliez
 *
 * created 12 juil. 2017
 */
public class JWTLoginFilter extends AbstractAuthenticationProcessingFilter {

	public JWTLoginFilter(String url, AuthenticationManager authManager) {
		super(new AntPathRequestMatcher(url));
		setAuthenticationManager(authManager);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res)
			throws AuthenticationException, IOException, ServletException {
		if(HttpMethod.POST.toString().equals(req.getMethod())){
			AccountCredentials creds = new ObjectMapper().readValue(req.getInputStream(), AccountCredentials.class);
			return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(creds.getUsername(),
					creds.getPassword(), Collections.emptyList()));
		}else{
			throw new ServletException("Not a POST call");
		}
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		TokenAuthenticationService.addAuthentication(res, auth.getName());
	}
}