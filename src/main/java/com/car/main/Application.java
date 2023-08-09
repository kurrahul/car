package com.car.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.WebApplicationInitializer;



//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@ComponentScan({ "com.car.config.entity", "com.car.repository.CarRepository", "com.car.controller",
	"com.car.service"})
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {

	private static final Logger LOG = LoggerFactory.getLogger(Application.class);
	
	  public static void main(String[] args) {
		  LOG.info("Starting up the application");
	        SpringApplication.run(Application.class, args);
	    }

	  @Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
			return builder.sources(Application.class);
		}
	  
}
