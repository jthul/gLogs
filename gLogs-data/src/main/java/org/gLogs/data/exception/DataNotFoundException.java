package org.gLogs.data.exception;

/**
 * Represents exceptions thrown when data are not found in the 
 * database
 * @author jThulliez
 *
 * created 12 juil. 2017
 */
public class DataNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public DataNotFoundException(String message) {
		super(message);
	}

}
