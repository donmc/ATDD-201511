package com.tddair;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ResisterMemberSteps {
	
	private TddAirApplication tddApp = new TddAirApplication();
	private Member member;

	@When("^registering a new member with username \"(.+)\"$")
	public void registering_a_new_member_with_username(String username)
			throws Throwable {
		tddApp.registerMember(username);
		member = tddApp.lookupMember(username);
	}

	@Then("^should find a member with username \"([^\"]*)\"$")
	public void should_find_a_member_with_username(String username)
			throws Throwable {
		Assert.assertEquals(username, member.getUserName());
	}

	@Then("^new member should have \"([^\"]*)\" status$")
	public void new_member_should_have_status(String status) throws Throwable {
		Assert.assertEquals(status, member.getStatus().toString());
	}

	@Then("^new member should have \"(\\d+)\" balance miles$")
	public void new_member_should_have_balance_miles(int balanceMiles)
			throws Throwable {
		Assert.assertEquals(balanceMiles, member.getBalanceMiles());
	}

	@Then("^new member should have \"(\\d+)\" ytd miles$")
	public void new_member_should_have_ytd_miles(int ytdMiles) throws Throwable {
		Assert.assertEquals(ytdMiles, member.getYtdMiles());
	}

}
