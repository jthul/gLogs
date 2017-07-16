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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceDAO")
public class UserServiceDAOImpl implements UserServiceDAO {

	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DatabaseService dbService;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean checkUserExistence(String userName) {
		try {
			getUserFromUsername(userName);
			return true;
		}catch(DataNotFoundException e) {
			return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDTO getUserFromUsername(String userName) throws DataNotFoundException {
		
		
		Nitrite db = dbService.getDatabaseConnection();
		
		ObjectRepository<UserDTO> repository = db.getRepository(UserDTO.class);
		UserDTO result = repository.find(ObjectFilters.eq("userName",userName)).firstOrDefault();
		
		//db.close();
		
		if(result != null ) {
			return result;
		}
		
		throw new DataNotFoundException("User {"+userName+"} not found in the database") ; 
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UserDTO> getUsers(){
		Nitrite db = dbService.getDatabaseConnection();
		
		List<UserDTO> dtoResult = new ArrayList<UserDTO>();
		
		ObjectRepository<UserDTO> repository = db.getRepository(UserDTO.class);
		repository.find().forEach(c ->dtoResult.add(c) );
		//db.close();
		
		return dtoResult;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void addUser(UserDTO user) {
		LOG.info("TEST ma gueule");
		if(!checkUserExistence(user.getUserName())) {
			Nitrite db = dbService.getDatabaseConnection();
			ObjectRepository<UserDTO> repository = db.getRepository(UserDTO.class);
			repository.insert(user);
			db.commit();
			//db.close();
			
		}
	}
	
	/*
	 * Getters setters
	 */
	public DatabaseService getDbService() {
		return dbService;
	}

	public void setDbService(DatabaseService dbService) {
		this.dbService = dbService;
	}

	
	

	
	
	
}
