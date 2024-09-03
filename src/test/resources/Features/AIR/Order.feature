Feature: Order Test


  Scenario: Create a new regular Order
    Given login for creating new Order
    And create new Order and verify its creation

  Scenario: Check the grand total calculation
    Given login for creating new Order
    And check grand total calculation of the orders


  Scenario: check the searchbar of the orders
    Given Login to Search Order
    And search for Order
    Then verify if the order is visible accordingly

  Scenario: future and previous date validation
    Given Login to Search Order
    When set previous date and future date for order creation

  Scenario: Description of an Order for AIR
    Given Login to Search Order
    When search for Order
    And description of a Order

  Scenario: Create a new Order with no products selected
    Given login for creating new Order
    When create new Order with no products in it


  Scenario: Create a new Order with zero products quantity
    Given login for creating new Order
    And creation of an order with zero product quantity in it

  Scenario: without selecting any products, click the plus button
    Given login for creating new Order
    And click the plus (add) button without selecting any products