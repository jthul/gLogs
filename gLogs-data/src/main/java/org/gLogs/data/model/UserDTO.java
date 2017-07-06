package org.gLogs.data.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

/**
 * DTO representing a user into the database.
 * 
 * TODO : We should do something so when we get this user 
 * in the app, we don't take the password each time
 * 
 * @author jthulliez
 * 
 */
public class UserDTO {
	private String userName, password;
	private List<Role> roles;

	public UserDTO() {
		roles = new ArrayList<Role>();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void addRole(String role) {
		roles.add(new Role(role));
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	class Role implements GrantedAuthority{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		String rolesString;
		public Role(String rolesS) {
			this.rolesString = rolesS;
		}
		
		@Override
		public String getAuthority() {
			return rolesString;
		}
		
	}
}
