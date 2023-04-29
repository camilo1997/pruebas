Feature: Get users to dummyapi

  Background: setUp
    Given I have acces to the service

  @GetAll
  Scenario: Get all users
    When I get all users
    Then I see the response code 200
    And I see that the answer is not empty

  @GetAllAppIdNotExist
  Scenario: Get all users with app-id not exist
    When I get all users with appid incorrect
    Then I see the response code 403
    And I see that message error