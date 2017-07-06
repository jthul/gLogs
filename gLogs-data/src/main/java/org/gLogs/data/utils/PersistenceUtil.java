package org.gLogs.data.utils;

import java.io.File;

/**
 * 
 * @author jThulliez
 *
 *  General informations is a singleton that contains all the information
 *  that we need in the application like os name, system parameter...
 * 
 */
public class PersistenceUtil {
	
	private static final String osName = System.getProperty("os.name"),
			persistenceDirectoryName = ".gLogs";

	private String persistenceDirectory;

	
	/*
	 * SINGLETON HANDLING HERE
	 */
	private static volatile PersistenceUtil instance;

	public PersistenceUtil() {
		this.persistenceDirectory = (
				osName != null && osName.startsWith("Windows") ? System.getenv("APPDATA") 
				: System.getProperty("user.home") ) + File.separator + persistenceDirectoryName; 
		if (instance != null) {
			throw new IllegalStateException("GeneralInformations already initialized ");
		}
	}

	public static PersistenceUtil getInstance() {
		PersistenceUtil result = instance;
		if (result == null) {
			synchronized (PersistenceUtil.class) {
				
				result = instance;
				if (result == null) {
					instance = result = new PersistenceUtil();
				}
			}
		}
		return result;
	}

	/*
	 * MAIN CONTENT OF THE CLASS
	 */

	// Name of the os
	
	public String getOsname() {
		return osName;
	}
	
	public String getPersistenceDirectory(){
		return persistenceDirectory;
	}
}