Feature: CancelOrder Test

  Scenario: Search an CancelOrder for AIR
    Given Login to Search CancelOrder
    When search for CancelOrder
    Then Verify that the cancel order is searched accordingly

  Scenario: view a CancelOrder for AIR
    Given Login to Search CancelOrder
    When search for CancelOrder
    And description of a cancelled Order

  Scenario: while creating a cancel order, check the price calculation
    Given Login to Search CancelOrder
    When check the price calculation of cancel order


  Scenario: Create a new regular cancelled Order
    Given login for Cancelling a Order
    And create new regular Cancel Order

  Scenario: Create a new partial cancelled Order
    Given login for Cancelling a Order
    And create new partial Cancel Order