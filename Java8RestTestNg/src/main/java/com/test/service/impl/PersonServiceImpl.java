package com.test.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.ctiteria.CheckPerson;
import com.test.model.Person;
import com.test.repository.PersonRepository;
import com.test.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	PersonRepository personRepository;
	
	public List<Person> getAllPerson() { 
		
		return personRepository.findAll();
/*		Person p;
		List<Person> persons=new ArrayList<Person>();
		 for(int i=1;i<=10;i++){
			 p=new Person();
			 p.setName("name"+i);
			 p.setEmailAddress("emailAddress"+i+"@gmail.com");
			 p.setBirthday(LocalDate.of(2004+i, 1+i, 1+i));
			 p.setGender(i%2==0?Person.Sex.MALE:Person.Sex.FEMALE);
			 persons.add(p);
		 }
		 return persons;*/
		
	}

	public void printPersonsOlderThan(List<Person> persons, int age) {
		for(Person person:persons){
			if(person.getAge()>=age){
				person.printPerson();
			}
		}
		
	}

	public void printPersonsAgeWithIn(List<Person> persons, int ageMin, int ageMax) {
		for(Person person:persons){
			if(person.getAge()>=ageMin && person.getAge()<=ageMax){
				person.printPerson();
			}
		}
		
	}

	public void printPersons(List<Person> persons, CheckPerson tester) {
		for(Person person:persons){
			if(tester.test(person)){
				person.printPerson();
			}
		}
		
	}

	@Override
	public void printPersonsWithPredicate(List<Person> persons, Predicate<Person> tester) {
		for(Person person:persons){
			if(tester.test(person)){
				person.printPerson();
			}
		}
	}

	@Override
	public void processPerson(List<Person> persons, Predicate<Person> tester, Consumer<Person> consumer) {
		for(Person person:persons){
			if(tester.test(person)){
				consumer.accept(person);
			}
			}
		}
	@Override
	public void processPerson(List<Person> persons, Predicate<Person> tester, Consumer<Person> consumer, Consumer<Object> after) {
		for(Person person:persons){
			if(tester.test(person)){
				consumer.accept(person);
				consumer.andThen(after).accept(person);;
			}
			}
		}

	@Override
	public void processPersonsWithFunction(List<Person> persons, Predicate<Person> tester, Consumer<String> consumer,
			Function<Person, String> mapper) {
		for(Person person:persons){
			if(tester.test(person)){
				String data=mapper.apply(person);
				consumer.accept(data);
			}
		}
	}

	@Override
	public <I, R> void processElements(List<I> elements, Predicate<I> tester,	Function<I, R> mapper, Consumer<R> consumer) {
		for(I i:elements){
			if(tester.test(i)){
				R out=mapper.apply(i);
				consumer.accept(out);
			}
		}
		
	}
}
