Feature: Create user in dummyapi

  Background: setUp
    Given I have acces to the service

  @CreateUserOk
  Scenario: Create user successful
    When I create user with data ok
    Then I see the response code 200
    And I see that the answer is not empty
    And I see user data