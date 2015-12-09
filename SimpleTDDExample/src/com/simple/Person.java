package com.simple;

public class Person {

	private String firstName;
	private String lastName;
	private String middleName;
	private Gender gender;
	
	public Person(String fn, String mn, String ln) {
		this(fn,mn, ln, Gender.UNKNOWN);
	}
	 
	public Person(String fn, String mn, String ln, Gender gender) {
		validateNames(fn, ln);
		this.firstName = fn; 
		this.lastName = ln;
		this.middleName = mn;
		this.gender = gender;
	}

	private void validateNames(String fn, String ln) {
		if (fn == null) throw new InvalidPersonException("Missing First Name!");
		if (ln == null) throw new InvalidPersonException("Missing Last Name!");
	}
	
	public String getFullName() {
		String fullName = null;
		
		if(hasNoMiddleName()) {
			fullName = firstName + " " + lastName;
		} else {
			fullName = firstName + " " + middleName + " " + lastName;
		}
		
		return fullName;
	}

	private boolean hasNoMiddleName() {
		return middleName == null || middleName.trim().isEmpty();
	}

	public String getFormalName() { 
		return gender.getSalutation() + " " + getFullName();
	}
}
