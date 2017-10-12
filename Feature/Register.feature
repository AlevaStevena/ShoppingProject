Feature: Register Test 

	@Register
Scenario: As a new user I want to register successfully
	Given I am on the Homepage 
	And I click on My Account Link
	And I see a welcome message banner
	When I enter all the user data in the registration form
	And I click the continue button
	Then my account should be created
	#And I log out
	