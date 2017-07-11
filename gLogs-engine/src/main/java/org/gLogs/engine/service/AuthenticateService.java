package org.gLogs.engine.service;

import org.gLogs.data.exception.DataNotFoundException;
import org.gLogs.data.model.UserDTO;

public interface AuthenticateService {
	public UserDTO authenticate(UserDTO userFromForm) throws DataNotFoundException ;
}
