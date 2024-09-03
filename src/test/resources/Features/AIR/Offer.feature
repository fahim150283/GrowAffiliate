Feature: Full Offer Test

  Scenario: create a new offer
    Given login for creation of an offer
    When create new offer
    And search for the offer
    Then close the offer window