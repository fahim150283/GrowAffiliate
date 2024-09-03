Feature: Finish Goods Store Test


  Scenario: Description of a FG Store and print details
    Given Login to Search a FG Store
    When search for FG Store
    And description of a store and print
    Then close window for searching a FG Store

  Scenario: Edit a FG Store
    Given Login to edit a FG Store
    When search for a FG Store
    And edit a store
    Then close window for editing a FG Store

  Scenario: Create a FG Store
    Given Login to Create a FG Store
    And create a store new FG Store
    Then close window for creating a FG Store

  Scenario: Add goods to store
    Given Login to add products in a  FG Store
    And Add goods to FG Store
    Then Close driver for adding goods to FG Store