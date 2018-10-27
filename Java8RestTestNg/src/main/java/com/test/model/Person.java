package com.test.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="person")
public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	Integer id;
	
	String name;
    LocalDate birthday;
    @Enumerated(EnumType.STRING)
    Sex gender;
    String emailAddress;
    public enum Sex {
        MALE, FEMALE
    }

    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}
	public Sex getGender() {
		return gender;
	}
	public void setGender(Sex gender) {
		this.gender = gender;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public int getAge() {
		int age=LocalDate.now().getYear()-this.getBirthday().getYear();
       return age;
    }

    public void printPerson() {
       System.out.println(this.getName()+": "+this.emailAddress+": "+this.getAge()+": "+this.getGender());
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return (this.getName()+": "+this.emailAddress+": "+this.getAge()+": "+this.getGender());
    }
}
