package org.gLogs.data.service;

import org.gLogs.data.model.UserDTO;

/**
 * Interface of the userDAO, <b>a service</b> that will help to get the 
 * user datas from the database
 * 
 * @author jThulliez
 *
 */
public interface UserServiceDAO {
	/**
	 * Search into the database the UserDTO corresponding to the userName
	 * <p>
	 * @param userName the userName of the UserDTO to select
	 * @return UserDTO or null if not found
	 */
	public UserDTO getUserFromUsername(String userName);
}
