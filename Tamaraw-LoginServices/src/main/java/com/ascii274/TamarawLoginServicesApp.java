package com.ascii274;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages = {"com.ascii274.login.repository"})
@ComponentScan({"com.ascii274.login","com.ascii274.login.repository"})
@EntityScan("com.ascii274.login.entitydto")
@EnableJpaRepositories("com.ascii274.login.repository")
@EnableWebMvc
public class TamarawLoginServicesApp {

	public static void main(String[] args) {
		SpringApplication.run(TamarawLoginServicesApp.class, args);
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
