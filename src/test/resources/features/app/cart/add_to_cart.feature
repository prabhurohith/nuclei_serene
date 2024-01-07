Feature: Add to car Feature


  #The scroll works but element goes out of the screen
  @current_device
  Scenario: Verify the left navigation options
    Given Marley logs into the saucelabs app
    Then he should be able to see that the 'home' page is loaded
    # Do the below with API
    # Check whether added through UI
    And he taps on the 'Sauce Labs Onesie' product
    Then he should be able to see that the 'details' page is loaded


