Feature: Get users to dummyapi

  Background: setUp
    Given I have acces to the service

  @GetAll
  Scenario: Get all users
    When I get all users
    Then I see the response code 200
    And I see that the answer is not empty

  @GetUserById
  Scenario: Get user by id
    When I get user by id
    Then I see the response code 200
    And I see that the answer is not empty

  @GetUserByIdIncorrect
  Scenario: Get user by id incorrect
    When I get user by id incorrect
    Then I see the response code 400
    And I see that message params not valid

  @GetAllUserWithAppIdIncorrect
  Scenario: Get all users with app-id incorrect
    When I get all users with appid incorrect
    Then I see the response code 403
    And I see that message error id not exist