Feature: Contacts Test

  Scenario: Check the searchbar

    Given login for accessing Contacts
    When search for employee
    And verify if the the employee is searched or not


