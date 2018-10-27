package com.test.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.model.Person;
import com.test.service.PersonService;

@RestController
public class PersonController {
	
	@Autowired
	PersonService personService;
	
	@RequestMapping(path="/hello",method=RequestMethod.GET)
	public String hello(){
		return "Hello Shaiju";
	}

	@RequestMapping(path="/persons",method=RequestMethod.GET)
	public List<Person> getAllPersons(){
		List<Person> persons=new ArrayList<>();
		 persons= personService.getAllPerson();
		 return persons;
	}
}
