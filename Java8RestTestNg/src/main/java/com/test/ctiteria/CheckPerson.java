package com.test.ctiteria;

import com.test.model.Person;

@FunctionalInterface
public interface CheckPerson {	
	public boolean test(Person p);
}
