Feature: Sort results on home page

  @current
  Scenario Outline: User is able to sort the search results on home page
    Given Marley logs into the app
    Then he should be able to see that the 'home' page is loaded
    When he sorts the results by <sort_category> in <sort_type>
    Then he should be able to see the search results are sorted by <sort_category> in <sort_type>

    Examples:
      | sort_category | sort_type    |
      | "Name"        | "Ascending"  |
      | "Name"        | "Descending" |




