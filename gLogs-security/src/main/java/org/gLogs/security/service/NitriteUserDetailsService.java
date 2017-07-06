package org.gLogs.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * This implementation of UserDetailsService will help 
 * to request user informations needed by spring security 
 * into the database
 * @author jThulliez
 *
 * created 6 juil. 2017
 */
public class NitriteUserDetailsService implements UserDetailsService {
	
	
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		
	}

}
