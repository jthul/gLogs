package org.gLogs.engine.service.impl;

import java.io.File;

import org.gLogs.data.model.DefaultSettingsDTO;
import org.gLogs.data.service.UserServiceDAO;
import org.gLogs.data.utils.PersistenceUtil;
import org.gLogs.engine.exception.InitException;
import org.gLogs.engine.service.InitializerService;
import org.gLogs.engine.utils.InitializerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("initService")
public class InitializerServiceImpl implements InitializerService {
	
	@Autowired
	private UserServiceDAO userServiceDAO;
	
	
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void launchInit() {
		boolean initDatabase = initPersistenceFolder() || checkDatabaseIncoherence();		
		if(initDatabase) {
			try {
				initializeDatabase();
			} catch (InitException e) {
				LOG.error("Error while initializing : " + e.getMessage());
			}
		}
	}
	
	/**
	 * 
	 * This method will initialize all the database parameters 
	 * from a config file
	 * 
	 */
	private void initializeDatabase() throws InitException{
		DefaultSettingsDTO defaultSettings = InitializerUtils.getDefaultSettingsDto();
		userServiceDAO.addUser(defaultSettings.getDefaultUser());
	}
	
	/**
	 * This method will check the incoherence of the database
	 * 
	 * @return false for coherent, true for incoherent
	 */
	private boolean checkDatabaseIncoherence() {
		return !(userServiceDAO.getUsers().size()>0);
	}
	
	/**
	 * Check if the persistence folder is created, create it if it isn't
	 */
	private boolean initPersistenceFolder() {
		if (!checkPersistenceFolder()) {
			boolean createDirectory = new File(PersistenceUtil.getInstance().getPersistenceDirectory()).mkdir();
			if (!createDirectory) ;
			else
				LOG.info("Folder created : " + PersistenceUtil.getInstance().getPersistenceDirectory());
			return true;
		}
		return false;
	}

	/**
	 * Check if the persistence directory is created.
	 * 
	 * @return true if it is, false if it isn't
	 */
	private boolean checkPersistenceFolder() {
		File persistenceFolder = new File(PersistenceUtil.getInstance().getPersistenceDirectory());
		if (persistenceFolder.exists() && persistenceFolder.isDirectory()) {
			return true;
		}
		return false;
	}

	public UserServiceDAO getUserServiceDAO() {
		return userServiceDAO;
	}

	public void setUserServiceDAO(UserServiceDAO userServiceDAO) {
		this.userServiceDAO = userServiceDAO;
	}
	
	
}
