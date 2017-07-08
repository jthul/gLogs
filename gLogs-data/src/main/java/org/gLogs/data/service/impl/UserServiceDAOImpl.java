package org.gLogs.data.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.gLogs.data.exception.DataNotFoundException;
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
	public UserDTO getUserFromUsername(String userName) throws DataNotFoundException {
		Nitrite db = dbService.getDatabaseConnection();
		
		ObjectRepository<UserDTO> repository = db.getRepository(UserDTO.class);
		UserDTO result = repository.find(ObjectFilters.eq("userName",userName)).firstOrDefault();
		
		db.close();
		
		if(result != null ) {
			return result;
		}
		
		throw new DataNotFoundException("User {"+userName+"} not found in the database") ; 
	}
	
	@Override
	public List<UserDTO> getUsers(){
		Nitrite db = dbService.getDatabaseConnection();
		
		List<UserDTO> dtoResult = new ArrayList<UserDTO>();
		
		ObjectRepository<UserDTO> repository = db.getRepository(UserDTO.class);
		repository.find().forEach(c ->dtoResult.add(c) );
		db.close();
		
		return dtoResult;
	}

	public DatabaseService getDbService() {
		return dbService;
	}

	public void setDbService(DatabaseService dbService) {
		this.dbService = dbService;
	}

	
	
	
}
