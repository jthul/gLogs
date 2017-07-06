package org.gLogs.data.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 * Configuration class for the data module
 * 
 * @author jThulliez
 *
 */
@Configuration
@ComponentScan({"org.gLogs.data.service"})
public class DataConfiguration {

}
