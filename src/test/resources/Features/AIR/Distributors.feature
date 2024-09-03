Feature: Distributors Test

  Scenario: Create a new Distributor
    Given login for Distributor
    And create new Distributor
    Then close the Distributor window

  Scenario: View and print a Distributor for AIR
    Given login for Distributor
    When search for Distributor
    And description of a Distributor
    Then print the distributor info
    And close Distributor for search

  Scenario: edit a  Distributor for AIR
    Given login for Distributor
    When search for Distributor
    And edit distributor
    Then close the Distributor window