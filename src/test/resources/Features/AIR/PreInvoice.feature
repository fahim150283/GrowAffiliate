Feature: PreInvoice Test


  Scenario: Search a PreInvoice for AIR
    Given Login to Search PreInvoice
    When search for preInvoice
    And description of a preinvoice
    Then close PreInvoice for search

  Scenario: Create a new preInvoice
    Given login for creating new preInvoice
    And create new preInvoice
    Then close the PreInvoice window