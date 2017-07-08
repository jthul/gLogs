package org.gLogs.data.service.impl;

import java.io.File;

import org.dizitart.no2.Nitrite;
import org.gLogs.data.service.DatabaseService;
import org.gLogs.data.utils.PersistenceUtil;
import org.springframework.stereotype.Service;

@Service("dbService")
public class DatabaseServiceImpl implements DatabaseService {

	private static String databaseName = "datas.db";
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Nitrite getDatabaseConnection() {
		Nitrite db = Nitrite.builder()
		        .filePath(PersistenceUtil.getInstance().getPersistenceDirectory() 
		        			+ File.separator + databaseName)
		        .openOrCreate();
		return db;
	}
}
