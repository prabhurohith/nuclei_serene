Feature: Login Feature

  Scenario Outline: Test the login with empty password
    Given Jack wants to sign in to Swag Labs
    When he enters user name as <username>
    And he enters the password as <password>
    And he clicks on login
    Then he is shown an error message as <error_msg>

    Examples:
      | username          | password       | error_msg                                             |
      | "standard_user"   | ""             | "Epic sadface: Password is required"                  |
#      | "locked_out_user" | "secret_sauce" | "Epic sadface: Sorry, this user has been locked out." |
#      | "problem_user"    | "secret_sauce" | "Epic sadface: Sorry, this user has been locked out." |
#

#  Scenario: Check if the login page is displayed when user navigates to login
#    Given Jack goes to the saucelabs 'login' page
#    Then he should be able to see that the 'login' page is complete displayed




