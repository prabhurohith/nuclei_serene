Feature: Pet Store Ops

#  @current_api
  Scenario: Search for doggie in pet store
    Given Marley wants to search for doggie in the pet store
    When I ask for a pet using id as 1
    Then I get 'doggie' as result

#  @current_api
  Scenario: Search for a pet which isnt there in store
    Given Marley wants to search for doggie in the pet store
    When I ask for a pet using id as 0
    Then I get as pet not found

  @current_api
  Scenario: Create a Pet in Pet Store
    Given Marley wants to add a pet in the pet store
    And names the pet as 'Dogzilla' with a id as 123
    And tags it as a 'Dog' with id as 0
    And makes it available for adoption
    When he adds the pet
    Then he should see that the pet is added successfully




  #Add some new pet with help of post
  # Create a Pet -> get the pet -> edit the pet -> delete the pet :: Do it in a different file

  # Edit Pet
    # Create a pet , get it , edit it , check edit successful
    # See for optimisation : move const to enums 





