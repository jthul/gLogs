package org.gLogs.data.service.impl;

import org.dizitart.no2.Nitrite;
import org.gLogs.data.service.DatabaseService;
import org.gLogs.data.utils.DatabaseSingleton;
import org.springframework.stereotype.Service;

@Service("dbService")
public class DatabaseServiceImpl implements DatabaseService {

	
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Nitrite getDatabaseConnection() {
		return DatabaseSingleton.getInstance().getDb();
	}
}
