package org.gLogs.war.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	@RequestMapping(value = "/infos", method = RequestMethod.GET)
	public void getInfos() {
			
	}
	
	@RequestMapping(value="/checkToken", method = RequestMethod.GET)
	public boolean checkToken(){
		return true;
	}
}
