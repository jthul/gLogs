package org.gLogs.war.component;

import org.gLogs.engine.service.InitializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
/**
 * This is the component that will handle the call to the initalizer service 
 * at the start of the server.
 * 
 * @author jThulliez
 *
 * created 12 juil. 2017
 */
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
