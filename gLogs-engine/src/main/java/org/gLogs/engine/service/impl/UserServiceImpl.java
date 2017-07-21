package org.gLogs.engine.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.gLogs.data.exception.DataNotFoundException;
import org.gLogs.data.model.UserDTO;
import org.gLogs.data.service.UserServiceDAO;
import org.gLogs.engine.service.UserService;
import org.gLogs.security.config.TokenAuthentificationInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

	private Logger LOG = LoggerFactory.getLogger(this.getClass()); 
	
	@Autowired
	TokenAuthentificationInterface tokenAuthenticationService;
	
	@Autowired
	UserServiceDAO userServiceDAO;
	
	@Override
	public UserDTO getUserInfos(HttpServletRequest req) {
		Authentication auth = tokenAuthenticationService.getAuthUser(req);
		try {
			UserDTO user = userServiceDAO.getUserFromUsername(auth.getName());
			user.setPassword(null);
			return user;
		} catch (DataNotFoundException e) {
			LOG.error("User not found", e.getMessage());
			return null;
		}
	}

	public TokenAuthentificationInterface getTokenAuthenticationService() {
		return tokenAuthenticationService;
	}

	public void setTokenAuthenticationService(TokenAuthentificationInterface tokenAuthenticationService) {
		this.tokenAuthenticationService = tokenAuthenticationService;
	}

	
}
