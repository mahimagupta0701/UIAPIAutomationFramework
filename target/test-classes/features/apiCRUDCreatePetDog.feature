@test
Feature: Petstore API Testing

  Scenario: Create a new pet
    Given I create a pet with name "doggie", category "Dogs", photoUrl "http://image.jpg", tag "friendly", status "available"
    Then the response code should be 200
  Scenario: Get a new pet
    Given I get the pet with ID 10
    Then the response code should be 200
  Scenario: Update the pet
    Given I update the pet with ID 10 to have name "updatedDoggie", category "Dogs", photoUrl "http://image.jpg", tag "loyal", status "sold"
    Then the response code should be 200
  Scenario: Delete an existing pet
    Given I delete the pet with ID 10
    Then the response code should be 200
