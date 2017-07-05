package org.gLogs.war.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * Status controller is a basic controller that will help 
 * to know what are the server services status.
 * 
 * 
 * @author jThulliez
 *
 * created 22 june 2017
 */
@Controller
public class StatusController {
	@RequestMapping("/serverStatus")
    public String serverIsUp(Map<String, Object> model) {
		model.put("message", "Server is runing ! ");
		return "serverIsUp";
    }
}
