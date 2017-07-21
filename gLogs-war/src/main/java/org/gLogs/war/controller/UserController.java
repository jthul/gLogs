package org.gLogs.war.controller;

import javax.servlet.http.HttpServletRequest;

import org.gLogs.data.model.UserDTO;
import org.gLogs.engine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/infos", method = RequestMethod.GET)
	public UserDTO getInfos(HttpServletRequest req) {
		return userService.getUserInfos(req);
	}
	
	@RequestMapping(value="/checkToken", method = RequestMethod.GET)
	public boolean checkToken(){
		return true;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
}
