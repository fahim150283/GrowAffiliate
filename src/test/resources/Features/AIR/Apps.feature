Feature: Apps Test


  Scenario: test Searchbar
    Given login for creating new app
    When search for the app
    And verify that the app is listed in the apps list


  Scenario: Create a new  app
    Given login for creating new app
    When create new  app
    And verify that the app is created and listed in the apps list


  Scenario: Edit an app
    Given login for editing an app
    When search for the app
    And edit the app
    Then verify that the app is edited


  Scenario: Create a new  app
    Given login for creating new app
    When create new  app
    And verify that the app is created and listed in the apps list


  Scenario: Give permission to a user for an App
    Given login for giving access to an user
    When search for the app to give access
    And add permission

  Scenario: Revoke permission of a user for an App
    Given login for giving access to an user
    When search for the app to give access
    And Revoke user permission

  Scenario: Give permission to a user for an App
    Given login for giving access to an user
    When search for the app to give access
    And add permission

  Scenario: verify if the 1st user has access to the app
    Given login for checking access of first user
    And verify from the side panel

  Scenario: verify if the 2nd user has access to the app
    Given login for checking access of 2nd user
    And verify from the side panel
