package org.gLogs.war.status;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StatusController {
	
	@RequestMapping("/test")
    public String serverIsUp(Map<String, Object> model) {
		model.put("message", "Toto is alive");
		return "serverIsUp";
    }
	
}
