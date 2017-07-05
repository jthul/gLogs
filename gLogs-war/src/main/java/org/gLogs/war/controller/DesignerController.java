package org.gLogs.war.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DesignerController {
	@RequestMapping("/designer")
    public String designer(Map<String, Object> model) {
		return "designer";
    }
}
