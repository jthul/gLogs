package org.gLogs.war.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	Logger log = LoggerFactory.getLogger(LoginController.class);
	
	
	
	@RequestMapping("/login.do")
    public String serverIsUp(Map<String, Object> model) {
		//log.debug("Test Login : " + loginService);
		return "login";
    }

	
	
}
