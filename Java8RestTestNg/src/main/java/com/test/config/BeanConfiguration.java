package com.test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.test.service.PersonService;
import com.test.service.impl.PersonServiceImpl;

@Configuration
public class BeanConfiguration {
	
	/*@Bean
	public PersonService getPersonService() {
		return new PersonServiceImpl();
	}*/

}
