Feature: Pet Store Ops

#  @current_api
  Scenario: Search for doggie in pet store
    Given Marley wants to search for doggie in the pet store
    When I ask for a pet using id as 1
    Then I get doggie as result

#  @current_api
  Scenario: Search for a pet which isnt there in store
    Given Marley wants to search for doggie in the pet store
    When I ask for a pet using id as 0
    Then I get as pet not found

#  @current_api
  Scenario: Create a Pet in Pet Store
    Given Marley wants to add a pet in the pet store
    And names the pet as 'Dogzilla' with a id as 123
    And tags it as a 'Dog' with id as 0
    And makes it available for adoption
    When he adds the pet
    Then he should see that the pet is added successfully
#    And he remembers the pet created
#    And changes the pet name to 'DogSheep'
#    Then he should see that the pet is edited successfully

  @current_api
  Scenario: Edit the created Pet
    Given Marley wants to edit a pet in the pet store
    When I ask for a pet using id as 123
    And change the name of the pet
    Then he should see that the changes made to pet in the store are successful
    And he is able to fetch the pet details using the new name
    # Map the response to common entity like pet so that assertions can be useful


#    And changes the pet name to 'DogSheep'
#    Then he should see that the pet is edited successfully

# Serenity doesnt allow sharing between the scenarios , plz find some alternate way ,
# but as per serenity this is aniti pattern as scenarios should be independent so either create and edit or else find
#  way to store the variable





