package com.tddair;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class TrackMilesSteps {
	
	private TddAirApplication app = TddAirAppSingleton.getInstance();
	private Member member;
	
	@Given("^a \"([^\"]*)\" member \"([^\"]*)\" with \"(\\d+)\" ytd miles$")
	public void a_member_with_ytd_miles(String status, String userName, int ytdMiles) throws Throwable {
	   app = TddAirAppSingleton.newInstance();
	   app.registerMember(userName);
	   member = app.lookupMember(userName);
	   
	   member.registerFlownMiles(ytdMiles);
	}

	@When("^they fly \"(\\d+)\" miles$")
	public void they_fly_miles(int milesFlown) throws Throwable {
	    member.registerFlownMiles(milesFlown);
	}
}
