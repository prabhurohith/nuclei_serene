Feature: Search by keyword

#  Scenario: Searching for a term
#    Given Sergey is researching things on the internet
#    When he looks up "Cucumber"
#    Then he should see information about "Cucumber"

  Scenario Outline: Test the login with empty password
    Given Alex wants to sign in to Swag Labs
    When he enters user name as <username>
    And he enters the password as <password>
    And he clicks on login
#    Then he is able to see the corresponding error message

    Examples:
      | username      | password |
      | standard_user | ""       |

