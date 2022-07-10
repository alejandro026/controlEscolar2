package com.utng.controlescolar2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableWebMvc
@SpringBootApplication
@EnableSwagger2
@ComponentScan("com.utng")
public class ControlEscolar2Application {

	public static void main(String[] args) {
		SpringApplication.run(ControlEscolar2Application.class, args);
	}
	
}
