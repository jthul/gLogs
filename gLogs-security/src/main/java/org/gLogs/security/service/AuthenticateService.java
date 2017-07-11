package org.gLogs.security.service;

import org.gLogs.data.model.UserDTO;

public interface AuthenticateService {
	public UserDTO authenticate(UserDTO userFromForm) ;
}
