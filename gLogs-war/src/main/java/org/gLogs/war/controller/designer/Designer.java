package org.gLogs.war.controller.designer;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Designer {
	@RequestMapping("/designer")
    public String designer(Map<String, Object> model) {
		return "designer";
    }
}
