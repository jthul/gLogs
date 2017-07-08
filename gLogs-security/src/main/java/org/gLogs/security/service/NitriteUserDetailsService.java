package org.gLogs.security.service;

import org.gLogs.data.exception.DataNotFoundException;
import org.gLogs.data.model.UserDTO;
import org.gLogs.data.service.UserServiceDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * This implementation of UserDetailsService will help to request user
 * informations needed by spring security into the database
 * 
 * @author jThulliez
 *
 *         created 6 juil. 2017
 */
@Service("nitriteUserDetailsService")
public class NitriteUserDetailsService implements UserDetailsService {

	Logger Log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserServiceDAO userServiceDAO;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		try {
			UserDTO userDTO = userServiceDAO.getUserFromUsername(userName);
			UserDetails user = new User(userDTO.getUserName(), userDTO.getPassword(), userDTO.getRoles());
			return user;
		} catch (DataNotFoundException e) {
			Log.error(e.getMessage());	
			throw new UsernameNotFoundException(e.getMessage());
		}

	}
}
