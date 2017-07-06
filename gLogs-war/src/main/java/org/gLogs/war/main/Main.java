package org.gLogs.war.main;


import javax.annotation.PostConstruct;

import org.gLogs.engine.service.InitializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * This is the springboot initializer.
 * We just call the appConfig package by using the component scan
 * @author thulliezj
 *
 */
@ComponentScan("org.gLogs.war.config")
@SpringBootApplication
public class Main extends SpringBootServletInitializer {

	@Autowired
	InitializerService initService;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Main.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	
	/**
	 * This is the method called just after the 
	 * dependencies are injected
	 */
	@PostConstruct
    public void init(){
        initService.launchInit();
    }
}
