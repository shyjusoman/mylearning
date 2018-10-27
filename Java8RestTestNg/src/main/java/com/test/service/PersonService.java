package com.test.service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.test.ctiteria.CheckPerson;
import com.test.model.Person;

public interface PersonService{
	List<Person> getAllPerson();
	void printPersonsOlderThan(List<Person> persons,int age);
	void printPersonsAgeWithIn(List<Person> persons,int ageMin,int ageMax);
	void printPersons(List<Person> persons,CheckPerson t);
	void printPersonsWithPredicate(List<Person> persons,Predicate<Person> tester);
	void processPerson(List<Person> persons,Predicate<Person> tester,Consumer<Person> consumer);
	void processPerson(List<Person> persons,Predicate<Person> tester,Consumer<Person> consumer,Consumer<Object> after);
	void processPersonsWithFunction(List<Person> persons,Predicate<Person> tester,Consumer<String> consumer,Function<Person, String> mapper);
	<I, R> void processElements(List<I> persons,Predicate<I> tester,Function<I, R> mapper,Consumer<R> consumer);
	
}
