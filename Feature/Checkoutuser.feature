Feature: Checkout Test

  @Checkout
  Scenario: As a register user I should be able to shop and checkout successfully
    Given I am on the Homepage
    And I click on My Account Link
    And I see a welcome message banner
    When I enter a valid username
    And I enter a valid password
    And I click the sign in button
    And I click on the Checkout Link
    And I click on the continue button
    And I picked my item
    And I add to Cart
    When I click the checkout button
    And I click the continue button
    And I click payment method
    And I click the continue button
    When I click the Confirm Order button
    Then I should see your order has been processed

    
 