package org.gLogs.engine.service;

/**
 * 
 * Initializer service is the service that will init all the 
 * datas into the database if it detects that i
 * 
 * @author jThulliez
 *
 */
public interface InitializerService {
	
	/**
	 * Will check if the app has all the mandatory parameters 
	 * set into the database
	 * 
	 * If the app is not correctly initialized, this method will
	 * do it.
	 * 
	 */
	public void launchInit();
}
