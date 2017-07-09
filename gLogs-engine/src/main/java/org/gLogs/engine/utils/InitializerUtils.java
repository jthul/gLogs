package org.gLogs.engine.utils;

import java.io.File;
import java.io.IOException;

import org.gLogs.data.model.DefaultSettingsDTO;
import org.gLogs.engine.exception.InitException;
import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * Some utils methods that will help in the initializing
 * process
 * 
 * @author jthulliez
 *
 */
public class InitializerUtils {
	private static String defaultJsonFileName = "init.json";
	
	public static DefaultSettingsDTO getDefaultSettingsDto() throws InitException {
		ObjectMapper mapper = new ObjectMapper();
		DefaultSettingsDTO defaultSettings;
		try {
			defaultSettings = mapper.readValue(InitializerUtils.getDefaultJson(), DefaultSettingsDTO.class);
			return defaultSettings;
		} catch (IOException e) {
			throw new InitException("Impossible to read or map the init file " + e.getMessage());
		}
	}
	
	private static File getDefaultJson() throws IOException {
		return (new ClassPathResource(defaultJsonFileName).getFile());
	}
}
