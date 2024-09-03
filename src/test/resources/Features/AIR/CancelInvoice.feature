Feature: Cancel Invoice Test

  Scenario: Create a new cancel Invoice
    Given login for cancellation of an Invoice
    And create new regular cancel Invoice

  Scenario: Search a cancelled Invoice for AIR
    Given Login to Search cancelled Invoice
    When search for cancelled Invoice
    And verify that the cancelled invoice is searched

  Scenario: View a cancelled Invoice for AIR
    Given Login to Search cancelled Invoice
    When search for cancelled Invoice
    And description of a cancelled Invoice

  Scenario: Check the price calculation for the cancelled invoice
    Given Login to Search cancelled Invoice
    When search for cancelled Invoice
    And description of a cancelled Invoice
    And check grand total calculation of the cancelled invoice