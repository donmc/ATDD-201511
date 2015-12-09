Feature: Register Member
As a frequent flier I want to register as a member so that I can collect miles and get perks

  Scenario: Save New Members
	When registering a new member with username "donmc"
	Then should find a member with username "donmc"
	And new member should have "RED" status
	And new member should have "10000" balance miles
	And new member should have "0" ytd miles
	
  
	
	
	