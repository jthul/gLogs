package org.gLogs.engine.initializer;

import java.io.File;
import java.io.IOException;

import org.gLogs.data.model.DefaultSettingsDTO;
import org.gLogs.data.model.SettingsDTO;
import org.gLogs.data.model.UserDTO;
import org.gLogs.data.referential.LanguageEnum;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InitJsonForInitializer {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		DefaultSettingsDTO defaultSettings = new DefaultSettingsDTO();
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName("admin");
		userDTO.setPassword("admin");
		userDTO.addRole("ROLE_ADMIN");
		
		SettingsDTO settings = new SettingsDTO();
		settings.setLanguage(LanguageEnum.EN);
		
		defaultSettings.setDefaultUser(userDTO);
		defaultSettings.setSettings(settings);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("src/main/resources/init.json"), defaultSettings);
		System.out.println("This is good");
	}
}
