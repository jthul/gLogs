package org.gLogs.engine.service;

import javax.servlet.http.HttpServletRequest;

import org.gLogs.data.model.UserDTO;

/**
 * Represents the service used in order to handle the users
 * 
 * @author thulliezj
 *
 */
public interface UserService {
	UserDTO getUserInfos(HttpServletRequest req);
}
