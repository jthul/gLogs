package org.gLogs.war.controller;

import javax.servlet.http.HttpServletResponse;

import org.gLogs.data.model.UserDTO;
import org.gLogs.security.service.AuthenticateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api")
public class LoginController {
	
	Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private AuthenticateService authenticationService;
	
	@RequestMapping(value = "/authenticate", method=RequestMethod.POST)
    public UserDTO authenticate(@RequestBody UserDTO userFromForm, HttpServletResponse response) {
		return authenticationService.authenticate(userFromForm);
    }

	
	
}
