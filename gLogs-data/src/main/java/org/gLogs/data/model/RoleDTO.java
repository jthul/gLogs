package org.gLogs.data.model;

import org.springframework.security.core.GrantedAuthority;

public class RoleDTO implements GrantedAuthority{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RoleDTO() {
	}
	
	String rolesString, authority;
	public RoleDTO(String rolesS) {
		this.rolesString = rolesS;
	}
	
	@Override
	public String getAuthority() {
		return rolesString;
	}

	public String getRolesString() {
		return rolesString;
	}

	public void setRolesString(String rolesString) {
		this.rolesString = rolesString;
	}
	
	
	
}
