Feature: Home Landing Feature

  Scenario: Check if the user is navigated to home page after successful login
    Given Marley logs into the saucelabs app
    Then he should be able to see that the 'home' page is loaded
    Then he should be able to see that the 'home' page is complete displayed

  @current
  Scenario: Verify the left navigation options
    Given Marley logs into the saucelabs app
    Then he should be able to see that the 'home' page is loaded
    And he opens the left navigation
    Then he should see that the 'left navigation' options are displayed



