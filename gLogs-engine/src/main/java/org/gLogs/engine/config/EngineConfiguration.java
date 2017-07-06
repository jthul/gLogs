package org.gLogs.engine.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"org.gLogs.engine.service.impl","org.gLogs.data.config"})
public class EngineConfiguration {

}
