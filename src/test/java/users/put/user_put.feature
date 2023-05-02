Feature: Update user in dummyapi

  Background:
    * url "https://dummyapi.io/data/v1/"
    * configure headers = {app-id:'644c74a50257e775130b1bb1'}
    * def generate = Java.type('utils.Generate')
    * def firstName = generate.firstName()
    * def lastName = generate.lastName()
    * def email = generate.email()
    * def body = read('/body.json')


  @UpdateUserOk
  Scenario: Update user that exist
    * call read('../post/user_post.feature@CreateUserOk')
    Given path 'user/'
    And path userId
    And request body
    When method PUT
    Then status 200
    And match response.id == userId
    * print response

  @UpdateUserNotExist
  Scenario: Update user that not exist
    * def userId = generate.idIncorrect()
    Given path 'user/'
    And path userId
    And request body
    When method PUT
    Then status 400
    And match response.error == 'PARAMS_NOT_VALID'
    * print response

