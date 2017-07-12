package org.gLogs.data.exception;

/**
 * Represents exceptions thrown by the database access
 * @author jThulliez
 *
 * created 12 juil. 2017
 */
public class DatabaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DatabaseException(String message) {
		super(message);
	}
	
}
