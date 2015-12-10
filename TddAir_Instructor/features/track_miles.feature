Feature: Track Miles
As a frequent flier I want my miles tracked so that I can earn status

	Scenario: Earn GREEN Status
		Given a "RED" member "bob" with "20000" ytd miles
		When they fly "5000" miles
		Then member "bob" should have "GREEN" status
		And member "bob" should have "25000" ytd miles
		And member "bob" should have "35000" balance miles

	Scenario: Stay RED Status
		Given a "RED" member "bob" with "20000" ytd miles
		When they fly "4999" miles
		Then member "bob" should have "RED" status
		And member "bob" should have "24999" ytd miles