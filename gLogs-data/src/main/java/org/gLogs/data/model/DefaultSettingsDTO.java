package org.gLogs.data.model;

/**
 * Represents the default settings read for the initialisation
 * 
 * @author Jérémy
 *
 */
public class DefaultSettingsDTO {
	private SettingsDTO settings;
	private UserDTO defaultUser;
	
	public DefaultSettingsDTO() {
		// TODO Auto-generated constructor stub
	}

	public SettingsDTO getSettings() {
		return settings;
	}

	public void setSettings(SettingsDTO settings) {
		this.settings = settings;
	}

	public UserDTO getDefaultUser() {
		return defaultUser;
	}

	public void setDefaultUser(UserDTO defaultUser) {
		this.defaultUser = defaultUser;
	}
	
	
}
