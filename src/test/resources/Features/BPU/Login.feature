Feature: Login Test for BPU


  Scenario: Login With invalid username and invalid password
    Given Navigate to AIR for BPU
    When Input the credentials(invalid username and invalid password) for BPU
    And verify if the login is unsuccessful for BPU


  Scenario: Login With invalid username and valid password
    Given Navigate to AIR for BPU
    When Input the credentials(invalid username and valid password) for BPU
    And verify if the login is unsuccessful for BPU


  Scenario: Login With valid username and invalid password
    Given Navigate to AIR for BPU
    When Input the credentials(valid username and invalid password) for BPU
    And verify if the login is unsuccessful for BPU


  Scenario: Login With valid username and valid password
    Given Navigate to AIR for BPU
    When Input the credentials(valid username and valid password) for BPU
    And verify if the login is successful for BPU
