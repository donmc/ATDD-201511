package com.tddair;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenRegisteringFlownMiles {

	@Test 
	public void shouldUpdateStatusToGreen() {
		Member member = new Member("donmc");
		member.registerFlownMiles(25000);
		assertEquals(Status.GREEN, member.getStatus());
	}
	
	@Test
	public void shouldUpdateStatusToBlue() {
		Member member = new Member("donmc");
		member.registerFlownMiles(50000);
		assertEquals(Status.BLUE, member.getStatus());
	}
	
	@Test
	public void shouldUpdateStatusToBlueAtEdge() {
		Member member = new Member("donmc");
		member.registerFlownMiles(49999);
		assertEquals(Status.GREEN, member.getStatus());
	}
	
	@Test
	public void shouldUpdateStatusToGold() {
		Member member = new Member("donmc");
		member.registerFlownMiles(75000);
		assertEquals(Status.GOLD, member.getStatus());
	}
}
