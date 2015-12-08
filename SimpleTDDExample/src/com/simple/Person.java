package com.simple;

public class Person {

	private String firstName;
	private String lastName;
	private String middleName;
	
	public Person(String fn, String mn, String ln) {
		if (fn == null) throw new InvalidPersonException("Missing First Name!");
		if (ln == null) throw new InvalidPersonException("Missing Last Name!");
		this.firstName = fn;
		this.lastName = ln;
		this.middleName = mn;
	}
	
	public String getFullName() {
		if(middleName == null || middleName.trim().isEmpty()) {
			return firstName + " " + lastName;
		}
		return firstName + " " + middleName + " " + lastName;
	}
}
