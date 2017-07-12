package org.gLogs.security.config;
/**
 * Represent the object get by the POST Login form
 * 
 * @author jThulliez
 *
 * created 12 juil. 2017
 */
public class AccountCredentials {

	private String username;
	private String password;
	// getters & setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}