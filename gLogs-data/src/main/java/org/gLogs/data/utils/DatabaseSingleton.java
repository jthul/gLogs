package org.gLogs.data.utils;

import java.io.File;

import org.dizitart.no2.Nitrite;

/**
 * Database singleton is a singleton used in order
 * to open the database once during the process of the app
 * 
 * @author thulliezj
 *
 */
public class DatabaseSingleton {
	/*
	 * Singleton
	 */
	private static volatile DatabaseSingleton instance;
	private static String databaseName = "datas.db";
	
	private Nitrite db;
	
	public DatabaseSingleton() {
		if (instance != null) {
			throw new IllegalStateException("DatabaseSingleton already initialized ");
		}
	}
	
	public static DatabaseSingleton getInstance() {
		DatabaseSingleton result = instance;
		if (result == null) {
			synchronized (DatabaseSingleton.class) {
				
				result = instance;
				if (result == null) {
					instance = result = new DatabaseSingleton();
				}
			}
		}
		return result;
	}

	public Nitrite getDb() {
		if(db == null){
			db = Nitrite.builder()
			        .filePath(PersistenceUtil.getInstance().getPersistenceDirectory() 
			        			+ File.separator + databaseName)
			        .openOrCreate(); 
		}
		return db;
	}

	public void setDb(Nitrite db) {
		this.db = db;
	}
	
	
}
