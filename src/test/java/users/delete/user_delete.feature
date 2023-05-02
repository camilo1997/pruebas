Feature: Delete user in dummyapi

  Background:
    * url "https://dummyapi.io/data/v1/"
    * configure headers = {app-id:'644c74a50257e775130b1bb1'}

  @CreateUserOk
  Scenario: Delete user existing
    * call read('../post/user_post.feature@CreateUserOk')
    Given path 'user/'
    And path userId
    When method DELETE
    Then status 200
    And match response.id == userId
    * print response

  @DeleteUserThatNotExist
  Scenario: Delete user that not exist
    * def generate = Java.type('utils.Generate')
    * def userId = generate.idIncorrect()
    Given path 'user/'
    And path userId
    When method DELETE
    Then status 400
    And match response.error == 'PARAMS_NOT_VALID'
    * print response