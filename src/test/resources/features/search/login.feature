Feature: Login Swag Labs

#  Scenario Outline: Test the login with empty password
#    Given Jack wants to sign in to Swag Labs
#    When he enters user name as <username>
#    And he enters the password as <password>
#    And he clicks on login
#    Then he is shown an error message as <error_msg>
#
#    Examples:
#      | username          | password       | error_msg                                             |
#      | "standard_user"   | ""             | "Epic sadface: Password is required"                  |
#      | "locked_out_user" | "secret_sauce" | "Epic sadface: Sorry, this user has been locked out." |
#      | "problem_user"    | "secret_sauce" | "Epic sadface: Sorry, this user has been locked out." |

  # Using this doesnt launch the browser
  Scenario Outline: Test the login with empty password
    Given <user> logs into the saucelabs app
    Then he is shown an error message as <error_msg>

    Examples:
      | user | error_msg                                             |
      | Jack | "Epic sadface: Password is required"                  |
      | Jill | "Epic sadface: Sorry, this user has been locked out." |
      | Bob  | "Epic sadface: Sorry, this user has been locked out." |



