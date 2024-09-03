Feature: Login Test


  Scenario: Login With invalid username and invalid password
    Given Navigate to AIR
    When Input the credentials(invalid username and invalid password)
    And verify if the login is unsuccessful


  Scenario: Login With invalid username and valid password
    Given Navigate to AIR
    When Input the credentials(invalid username and valid password)
    And verify if the login is unsuccessful


  Scenario: Login With valid username and invalid password
    Given Navigate to AIR
    When Input the credentials(valid username and invalid password)
    And verify if the login is unsuccessful


  Scenario: Login With valid username and valid password
    Given Navigate to AIR
    When Input the credentials(valid username and valid password)
    And verify if the login is successful
