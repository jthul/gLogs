package org.gLogs.data.service.impl;

import org.gLogs.data.model.UserDTO;
import org.gLogs.data.service.DatabaseService;
import org.gLogs.data.service.UserServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceDAO")
public class UserServiceDAOImpl implements UserServiceDAO {

	@Autowired
	private DatabaseService dbService;
	
	@Override
	public UserDTO getUserFromUsername(String userName) {
		UserDTO user = new UserDTO();
		user.setUserName("admin");
		user.setPassword("1234");
		user.addRole("ROLE_ADMIN");
		return user;
	}

	public DatabaseService getDbService() {
		return dbService;
	}

	public void setDbService(DatabaseService dbService) {
		this.dbService = dbService;
	}
	
	
}
