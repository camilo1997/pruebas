Feature: Delete user in dummyapi

  Background: setUp
    Given I have acces to the service

  @DeleteUserOK
  Scenario: Delete user existing
    When I delete user existing
    Then I see the response code 200
    And I see that id user

  @DeleteUserThatNotExist
  Scenario: Delete user that not exist
    When I delete user that not exist
    Then I see the response code 400
    And I see that message params not valid