package com.test;
import com.test.model.*;
import com.test.service.PersonService;
import com.test.service.impl.PersonServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonServiceApproach9 {
  
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
 public void testStream1() {
	 Stream<Person> streamOfPerson=persons.stream();
	 streamOfPerson.filter((p)-> { return p.getAge()>=8 && p.getAge()<=12;}).
	 map((p)->{return p.getName()+": "+p.getAge();}).forEach((o)->{System.out.println(o);});
 }

@Test
public void testStream2() {
	 Stream<Person> streamOfPerson=persons.stream();
	 streamOfPerson.filter((p)-> { return p.getAge()>=8 && p.getAge()<=12;}).
	 
	 forEach((o)->{System.out.println(o.toString());});
}
 
}
