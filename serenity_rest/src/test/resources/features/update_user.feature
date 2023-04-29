Feature: Update user in dummyapi

  Background: setUp
    Given I have acces to the service

  @UpdateUserOk
  Scenario: Update user that exist
    When I update user existing
    Then I see the response code 200
    And I see that the answer is not empty
    And I see new user data

  @UpdateUserNotExist
  Scenario: Update user that not exist
    When I update user not existing
    Then I see the response code 400
    And I see that message params not valid