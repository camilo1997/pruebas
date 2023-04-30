Feature: Get users to dummyapi

  Background:
    * url "https://dummyapi.io/data/v1/"
    * configure headers = {app-id:'644c74a50257e775130b1bb1'}
    * def generate = Java.type('utils.Generate')

  @GetAll
  Scenario: Get all users
    Given path 'user/'
    When method GET
    Then status 200
    And match response.total != 0
    * print response

  @GetUserById
  Scenario: Get user by id
    * call read('../post/user_post.feature@CreateUserOk')
    Given path 'user/'
    And path userId
    When method GET
    Then status 200
    And match response.id == userId

  @GetUserByIdIncorrect
  Scenario: Get user by id incorrect
    * def userId = generate.idIncorrect()
    Given path 'user/'
    And path userId
    When method GET
    Then status 400
    And match response.error == 'PARAMS_NOT_VALID'
    * print response

  @GetAllUserWithAppIdIncorrect
  Scenario: Get all users with app-id incorrect
    * call read('../post/user_post.feature@CreateUserOk')
    * configure headers = {app-id:'644c74a50257e775130b1bb1222'}
    Given path 'user/'
    And path userId
    When method GET
    Then status 403
    And match response.error == 'APP_ID_NOT_EXIST'
    * print response

  @GetAllUserWithPathIncorrect
  Scenario: Get all users with path incorrect
    * def userId = generate.idIncorrect()
    Given path 'users/'
    And path userId
    When method GET
    Then status 404
    And match response.error == 'PATH_NOT_FOUND'
    * print response