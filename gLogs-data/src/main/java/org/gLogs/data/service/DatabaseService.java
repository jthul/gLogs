package org.gLogs.data.service;

import org.dizitart.no2.Nitrite;

/**
 * 
 * Interface of the database Service that will help to connect to the database.
 * 
 * @author jThulliez
 *
 */
public interface DatabaseService {
	/**
	 * This method will return the database connection to the local database
	 * 
	 * @return
	 */
	public Nitrite getDatabaseConnection();
}
