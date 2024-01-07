Feature: Home Landing Feature


  # Browse for Products by scrolling (scrolling working but element to be scrolled is not proper , check again ==>
  # # May be fetch details and assign it to cards , ignore incomplete cards and then scroll on last compete card :: Resolved)
  # Then tap on the in view product (Click on the product using the saved element or else by again searching and matching text ) ::
  # # Scroll happening out of bounds hence app gng in bground
  # Verify all element details in the details
  #  Try to make login common

  Scenario: Check if the user is navigated to home page after successful login
    Given Marley logs into the saucelabs app
    Then he should be able to see that the 'home' page is loaded
    Then he should be able to see that the 'home' page is complete displayed

  Scenario: Verify the left navigation options
    Given Marley logs into the saucelabs app
    Then he should be able to see that the 'home' page is loaded
    And he opens the left navigation
    Then he should see that the 'left navigation' options are displayed

  #The scroll works but element goes out of the screen
  @current_device
  Scenario: Verify the left navigation options
    Given Marley logs into the saucelabs app
    Then he should be able to see that the 'home' page is loaded
    And he taps on the 'Sauce Labs Onesie' product
    Then he should be able to see that the 'details' page is loaded


