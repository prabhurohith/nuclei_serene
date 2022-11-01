Feature: Drawing Feature

  Scenario: Verify the left navigation options
    Given Marley logs into the saucelabs app
    Then he should be able to see that the 'home' page is loaded
    And he opens the left navigation
    And he goes to the saucelabs 'drawing' page
    Then he should be able to see that the 'drawing' page is loaded
    And he is able to save the drawing after recording it




