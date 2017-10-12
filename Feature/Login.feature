Feature: Test User Login

  @Login
  Scenario Outline: As a registered user I want to login successfully
    Given I am on the Homepage
    And I click on My Account Link
    And I see a welcome message banner
    When I enter a "<email>" detail
    And I enter a "<passw>" for the user
    And I click the sign in button
    Then I should be logged in
    Then I log off

    Examples: 
      | email                | passw     |
      | st.eromonsele@gmx.at | Avictor&1 |
      | maxwell642@yahoo.com | Avictor1  |
      | maxwell115@yahoo.com | Avictor1  |
      | maxwell845@yahoo.com | Avictor1  |

  @Login
  Scenario Outline: Its display error message when ivalis details are supplied
    Given I am on the Homepage
    And I click on My Account Link
    And I see a welcome message banner
    When I enter a "<email>" detail
    And I enter a "<passw>" for the user
    And I click the sign in button
    Then I should see error message

    Examples: 
      | email                   | passw       |
      | st.eromonsele@gmx.at    | Avictdfor&1 |
      | maxwell6rtgt2@yahoo.com | Avictor1    |
      | maxwell6rtgt2@yahoo.com | Avifggctor1 |
      |                         | Avictor1    |
      | maxwell845@yahoo.com    |             |
      |                         |             |
