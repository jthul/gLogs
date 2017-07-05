package org.gLogs.war.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping("/login.do")
    public String serverIsUp(Map<String, Object> model) {
		return "login";
    }
}
