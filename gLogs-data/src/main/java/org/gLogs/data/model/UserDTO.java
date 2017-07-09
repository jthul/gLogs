package org.gLogs.data.model;

import java.util.ArrayList;
import java.util.List;

import org.dizitart.no2.objects.Id;

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
	@Id
	private String userName;
	private String password;
	private List<RoleDTO> roles;

	public UserDTO() {
		roles = new ArrayList<RoleDTO>();
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
		roles.add(new RoleDTO(role));
	}
	
	public List<RoleDTO> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}
	
	
	
}
