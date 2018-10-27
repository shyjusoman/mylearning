package com.test.criteria.impl;

import com.test.ctiteria.CheckPerson;
import com.test.model.Person;

public class CheckPersonImpl implements CheckPerson{

	public boolean test(Person p) {
		return p.getGender()==Person.Sex.MALE && p.getAge()>=5 && p.getAge()<=10;
	}

}
