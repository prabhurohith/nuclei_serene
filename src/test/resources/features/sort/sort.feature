Feature: Home Landing Feature

  @current
  Scenario Outline: Check if the user is navigated to home page after successful login
    Given Marley logs into the app
    Then he should be able to see that the 'home' page is loaded
    When he sorts the results by <sort_category> in <sort_type>
    Then he should be able to see the search results are sorted by <sort_category> in <sort_type>

    Examples:
      | sort_category | sort_type    |
      | "Name"        | "Ascending"  |
      | "Name"        | "Descending" |




