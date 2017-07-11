package org.gLogs.war.component;

import org.gLogs.engine.service.InitializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class InitializerComponent implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private InitializerService initService;
	
	
	@Override
	public void onApplicationEvent(final ApplicationReadyEvent arg0) {
		initService.launchInit();
	}


	public InitializerService getInitService() {
		return initService;
	}


	public void setInitService(InitializerService initService) {
		this.initService = initService;
	}

	
}
