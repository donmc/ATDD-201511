package com.simple;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class PersonTest {

	private String fullName;
	private String fullNameSpace;
	private String fullNameNull;
	private String fullNameEmpty;
	
	@Before
	public void setup() {
		Person person = new Person("Don", "Thomas", "McGreal");
		Person personSpace = new Person("Don", " ", "McGreal");
		Person personNull = new Person("Don", null, "McGreal");
		Person personEmpty = new Person("Don", "", "McGreal");
		
		fullName = person.getFullName();
		fullNameSpace = personSpace.getFullName();
		fullNameNull = personNull.getFullName();
		fullNameEmpty = personEmpty.getFullName();
	}
	
	@Test
	public void testPersonCreation_MustHaveFirstName() {
		try {
			new Person(null, "Thomas", "McGreal");
			fail("Needs to throw InvalidPersonException");
		}catch(InvalidPersonException e) {
			assertEquals("Missing First Name!", e.getMessage());
		}
	}
	
	@Test(expected=InvalidPersonException.class) 
	public void testPersonCreation_MustHaveLastName() {
		new Person("don", "Thamas", null);
	}
	
	@Test
	public void testGetFullName_HappyPath() {
		
		assertEquals("Don Thomas McGreal", fullName);
	}
	
	@Test
	public void testGetFullName_MiddleNameBlankSpace() {
		
		assertEquals("Don McGreal", fullNameSpace);
	}
	
	@Test
	public void testGetFullName_MiddleNameNull() {
		
		assertEquals("Don McGreal", fullNameNull);
	}
	
	@Test
	public void testGetFullName_NoMiddleName() {
		assertEquals("Don McGreal", fullNameEmpty);
	}

}
