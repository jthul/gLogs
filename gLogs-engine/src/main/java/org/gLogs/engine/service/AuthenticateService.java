package org.gLogs.engine.service;

import org.gLogs.data.exception.DataNotFoundException;
import org.gLogs.data.model.UserDTO;

/**
 * Represents the service called in order to authenticate a user
 * @author jThulliez
 *
 * created 12 juil. 2017
 */
public interface AuthenticateService {
	/**
	 * Will authenticate a user thanks to he datas in the userDTO
	 * @param userFromForm
	 * @return
	 * @throws DataNotFoundException
	 */
	public UserDTO authenticate(UserDTO userFromForm) throws DataNotFoundException ;
}
