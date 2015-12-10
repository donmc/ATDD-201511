Feature: Register Member
As a frequent flier I want to register as a member so that I can collect miles and get perks

  Scenario: Save New Members
	When registering a new member with username "donmc"
	Then should find a member with username "donmc"
	And member "donmc" should have "RED" status
	And member "donmc" should have "10000" balance miles
	And member "donmc" should have "0" ytd miles
	
  Scenario: Duplicate UserNames
  	When registering a new member with username "donmc"
  	And registering a new member with username "donmc"
	Then should show error message "No Dupes!"
	
	