package org.gLogs.engine.service.impl;

import org.gLogs.data.service.UserService;
import org.gLogs.engine.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserService userService;

	
	/* Getters & setters */
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
