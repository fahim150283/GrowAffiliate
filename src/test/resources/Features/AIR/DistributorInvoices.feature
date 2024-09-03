Feature: Invoice Test

  Scenario: Search an Invoice for AIR
    Given Login to Search Invoice
    When search for Invoice
    Then verify if the invoice is searched accordingly

  Scenario: view an Invoice for AIR
    Given login for Invoice
    When search for Invoice
    And description of an Invoice

  Scenario: While creating an invoice, check if the orders in the selected date are visible only or not
    Given Login to Search Order
    When Gather the orders information
    When check if the orders that are created after the selected date are not visible, while creating an invoice,

  Scenario: While creating an invoice, check if if the invoice can be saved without selecting a store
    Given login for Invoice
    When check if the invoice can be created without selecting a store

  Scenario: new Invoice price calculation
    Given login for Invoice
    And verify the calculation of prices for an invoice

  Scenario: create an Invoice and verify the creation
    Given login for Invoice
    And create new Invoice and verify the creation

  Scenario: Creation of a new Invoice with no products in it
    Given login for Invoice
    And create a new Invoice with no products in it and verify that it is not created

  Scenario: Not allowing to create the invoice for more quantity of a product than the ordered quantity or the stock quantity is less than the invoice quantity
    Given login for Invoice
    And creation of an invoice where the product quantity is greater than the order quantity or the stock quantity is less than the invoice quantity
    Then verify that the invoice is not created

  Scenario: Not allowing to create the invoice for 0 total quantity in the invoice
    Given login for Invoice
    And creation of an invoice where the product quantity is zero as a total
    Then verify that the invoice is not created

  Scenario: creation of an invoice with no stores selected
    Given login for Invoice
    And creation of an invoice with no store selected