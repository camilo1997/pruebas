Feature: Create user in dummyapi

  Background: setUp
    Given I have acces to the service

  @CreateUserOk
  Scenario: Create user successful
    When I create user with data ok
    Then I see the response code 200
    And I see that the answer is not empty
    And I see user data

  @CreateUserWithEmailUsed
  Scenario: Create user with email already used
    When I create user with email already used
    Then I see the response code 400
    And I see that error message email already used

  @CreateUserWithOutEmail
  Scenario: Create user without email
    When I create user without email
    Then I see the response code 400
    And I see that error message email is required

  @CreateUserWithEmailIncorrect
  Scenario: Create user with email incorrect
    When I create user without email incorrect
    Then I see the response code 400
    And I see that error message email is invalid