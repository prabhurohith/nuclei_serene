Feature: Pet Store Ops

  @current_api
  Scenario: Get the id of a pet
    Given 'doggie' is available in the pet store
    When I ask for a pet using id as 1
    Then I get 'doggie' as result





