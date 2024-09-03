Feature: Collection Test


  Scenario: Search a Collection for AIR
    Given Login to Search Collection
    When search for Collection
    And description of a Collection

  Scenario: Create a new Collection for advance payment in cash
    Given login for creating Collection
    And create new Collection for advance payment in cash

  Scenario: Creation of a Collection for an order which will be adjusted from advance
    Given login for creating Collection
    And create new Collection for an order which will be adjusted from advance

  Scenario: creation of a Collection for order in cash
    Given login for creating Collection
    And create new Collection for order in cash

  Scenario: Creation of a Collection for advance payment in Instrument
#    Given login for creating Collection
#    And create new Collection
#    Then close the Collection window

  Scenario: Orders of a distributor will be visible according to the created date while making a collection
#    Given login for creating Collection
#    And create new Collection
#    Then close the Collection window