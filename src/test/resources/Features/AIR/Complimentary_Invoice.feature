Feature: Complementary Invoice Test


  Scenario: Search a Complementary Invoice for AIR
    Given Login to Search Complementary Invoice
    When search for Complementary Invoice
    And verify that the complementary invoice is searched

  Scenario: View a Complementary Invoice for AIR
    Given Login to Search Complementary Invoice
    When search for Complementary Invoice
    And description of a Complementary Invoice

  Scenario: Create a new Complementary Invoice
    Given login for creation of an Complementary Invoice
    And create new regular Complementary Invoice

  Scenario: Not allowing to create a new Complementary Invoice if the stock is less than selected amount for a product
    Given login for creation of an Complementary Invoice
    And create new regular Complementary Invoice for checking the stock error
    Then verify that the complementary invoice is not created