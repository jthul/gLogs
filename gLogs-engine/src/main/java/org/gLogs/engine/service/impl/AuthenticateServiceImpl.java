package org.gLogs.engine.service.impl;

import org.gLogs.data.exception.DataNotFoundException;
import org.gLogs.data.model.UserDTO;
import org.gLogs.engine.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service("authenticateService")
public class AuthenticateServiceImpl implements AuthenticateService {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Override
	public UserDTO authenticate(UserDTO userFromForm) throws DataNotFoundException {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userFromForm.getUserName(),userFromForm.getPassword());
		Authentication auth = null;
		try{
			auth = authenticationManager.authenticate(authenticationToken);
		}catch(BadCredentialsException e){
			throw new DataNotFoundException("Impossible to connect the user " + userFromForm.getUserName());
		}
		UserDTO user = new UserDTO();
		user.setUserName(auth.getName());
		auth.getAuthorities().forEach(e -> user.addRole(e.getAuthority()));
		
		//String secret = HmacSigner.generateSecret();
		return 	user;
	}

}
