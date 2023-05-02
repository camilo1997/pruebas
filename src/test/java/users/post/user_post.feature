Feature: Create user in dummyapi

  Background:
    * url "https://dummyapi.io/data/v1/"
    * configure headers = {app-id:'644c74a50257e775130b1bb1'}
    * def generate = Java.type('utils.Generate')

  @CreateUserOk
  Scenario: Create user successful
    * def firstName = generate.firstName()
    * def lastName = generate.lastName()
    * def email = generate.email()
    * def body = read('body.json')
    Given path 'user/create'
    And request body
    When method POST
    Then status 200
    And def userId = $.id

  @CreateUserWithEmailUsed
  Scenario: Create user with email already used
    * def firstName = generate.firstName()
    * def lastName = generate.lastName()
    * def email = 'test@test.com'
    * def body = read('/body.json')
    Given path 'user/create'
    And request body
    When method POST
    Then status 400
    And match response contains {error:'BODY_NOT_VALID'}
    And match response.data.email contains 'Email already used'
    * print response

  @CreateUserWithOutEmail
  Scenario: Create user without email
    Given path 'user/create'
    And request {firstName:"Santiago", lastName:"Zapata"}
    When method POST
    Then status 400
    And match response contains {error:'BODY_NOT_VALID'}
    And match response.data.email contains 'Path `email` is required.'
    * print response

  @CreateUserWithEmailIncorrect
  Scenario: Create user with email incorrect
    * def firstName = generate.firstName()
    * def lastName = generate.lastName()
    * def email = generate.emailIncorrect()
    * def body = read('/body.json')
    Given path 'user/create'
    And request body
    When method POST
    Then status 400
    And match response contains {error:'BODY_NOT_VALID'}
    And match response.data.email contains 'Path `email` is invalid'
    * print response