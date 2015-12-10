package com.tddair;

import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ResisterMemberSteps {

	private TddAirApplication tddApp = TddAirAppSingleton.getInstance();
	private Member member;
	private String errorMessage;

	@When("^registering a new member with username \"(.+)\"$")
	public void registering_a_new_member_with_username(String username)
			throws Throwable {
		try {
			tddApp.registerMember(username);
		} catch (IllegalArgumentException e) {
			this.errorMessage = e.getMessage();
		}
		member = tddApp.lookupMember(username);
	}

	@Then("^should find a member with username \"([^\"]*)\"$")
	public void should_find_a_member_with_username(String username)
			throws Throwable {
		Assert.assertEquals(username, member.getUserName());
	}

	@Then("^member \"([^\"]*)\" should have \"([^\"]*)\" status$")
	public void new_member_should_have_status(String userName, String status) throws Throwable {
		Member aMember = tddApp.lookupMember(userName);
		Assert.assertEquals(status, aMember.getStatus().toString());
	}

	@Then("^member \"([^\"]*)\" should have \"(\\d+)\" balance miles$")
	public void new_member_should_have_balance_miles(String userName, int balanceMiles)
			throws Throwable {
		Member aMember = tddApp.lookupMember(userName);
		Assert.assertEquals(balanceMiles, aMember.getBalanceMiles());
	}

	@Then("^member \"([^\"]*)\" should have \"(\\d+)\" ytd miles$")
	public void new_member_should_have_ytd_miles(String userName, int ytdMiles) throws Throwable {
		Member aMember = tddApp.lookupMember(userName);
		Assert.assertEquals(ytdMiles, aMember.getYtdMiles());
	}

	@Then("^should show error message \"([^\"]*)\"$")
	public void should_show_error_message(String errorMessage) throws Throwable {
		Assert.assertEquals(errorMessage, this.errorMessage);
	}

}
