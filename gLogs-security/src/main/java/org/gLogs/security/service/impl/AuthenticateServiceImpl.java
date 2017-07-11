package org.gLogs.security.service.impl;

import org.gLogs.data.model.UserDTO;
import org.gLogs.security.service.AuthenticateService;
import org.gLogs.security.service.NitriteUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service("authenticateService")
public class AuthenticateServiceImpl implements AuthenticateService {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	private NitriteUserDetailsService nitriteUserDetailsService;
	
	
	@Override
	public UserDTO authenticate(UserDTO userFromForm) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userFromForm.getUserName(),userFromForm.getPassword());
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		//Retrieve security user after authentication
		UserDetails securityUser = nitriteUserDetailsService.loadUserByUsername(userFromForm.getUserName());
		//String secret = HmacSigner.generateSecret();
	}

}
