package com.simple;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class WhenGettingAFormalName {
	
	@Test
	public void shouldStartWithMrForMen() {
		Person person = new Person("Don", "Thomas", "McGreal", Gender.MALE);
		String formalName = person.getFormalName();
		
		assertEquals("Mr. Don Thomas McGreal", formalName);
	}
	
	@Test
	public void shouldStartWithMsForWomen() {
		Person person = new Person("Dawn", "Thomasita", "McGreal", Gender.FEMALE);
		String formalName = person.getFormalName();
		
		assertEquals("Ms. Dawn Thomasita McGreal", formalName);
	}
	
	@Test
	public void shouldStartWithMrOrMsForUnknownGender() {
		Person person = new Person("Pat", "", "McGreal");
		String formalName = person.getFormalName();
		
		assertEquals("Mr. or Ms. Pat McGreal", formalName);
	}

}
