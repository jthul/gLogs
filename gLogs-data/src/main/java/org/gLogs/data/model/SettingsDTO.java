package org.gLogs.data.model;

import org.gLogs.data.referential.LanguageEnum;

/**
 * This represents all the settings of the application.
 *  
 * @author jthulliez
 *
 */
public class SettingsDTO {
	private LanguageEnum language;
	

	public LanguageEnum getLanguage() {
		return language;
	}

	public void setLanguage(LanguageEnum language) {
		this.language = language;
	}
}
