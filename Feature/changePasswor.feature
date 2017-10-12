Feature: Change Password

	@Changepassword
  Scenario: As a registered user I want to login to changemy password
    Given I am on the Homepage
    And I click on My Account Link
    And I see a welcome message banner
    When I enter a valid username
    And I enter a valid password
    And I click the sign in button
    And I should be logged in
    And I click my change my password button
    When I enter my current password
    And I enter my new pssword
    And I enter my password confirmation
    And I click the continue button
    Then my password should be chnged
