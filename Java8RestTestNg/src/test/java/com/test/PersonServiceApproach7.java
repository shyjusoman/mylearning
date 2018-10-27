package com.test;
import com.test.criteria.impl.CheckPersonImpl;
import com.test.ctiteria.CheckPerson;
import com.test.model.*;
import com.test.service.PersonService;
import com.test.service.impl.PersonServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonServiceApproach7 {
  
 List<Person> persons;
 PersonService personService;
 
 @BeforeMethod
 private void prepareData(){
	 Person p;
	 persons=new ArrayList<Person>();
	 personService=new PersonServiceImpl();
	 for(int i=1;i<=10;i++){
		 p=new Person();
		 p.setName("name"+i);
		 p.setEmailAddress("emailAddress"+i+"@gmail.com");
		 p.setBirthday(LocalDate.of(2004+i, 1+i, 1+i));
		 p.setGender(i%2==0?Person.Sex.MALE:Person.Sex.FEMALE);
		 persons.add(p);
	 }
 }
//@Test
 public void testPersonService() {
	  personService.processPerson(persons,(p)->{
		  return p.getGender().equals(Person.Sex.MALE) && p.getAge()>=10;
	  },(p)->{
		  System.out.println(p.getName()+": "+p.getAge()+": "+p.getGender());
	  });
 }
 
// @Test
 public void testPersonService2() {
	  personService.processPerson(persons,(p)->{
		  return p.getGender().equals(Person.Sex.MALE) && p.getAge()>=10;
	  },(p)->{
		 p.setEmailAddress(p.getName()+"@newEmail"+".com");
	  },System.out::println);
 }
 
 @Test
 public void testPersonService3() {
	  personService.processPersonsWithFunction(persons,(p)->{
		  return p.getGender().equals(Person.Sex.MALE) && p.getAge()>=10;
	  },(d)->{System.out.println(d);
	  },(p)->{return p.getName();});
 }
}
