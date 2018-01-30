package org.ptc.webapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PtcApplication extends ServletInitializer{

	private static final Logger log = LoggerFactory.getLogger(PtcApplication.class);
	
	private static Class<PtcApplication> applicationClass = PtcApplication.class;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		log.info("Starting Application");
		SpringApplication.run(applicationClass, args);
	}
}
