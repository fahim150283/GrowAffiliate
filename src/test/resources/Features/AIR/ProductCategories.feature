Feature: Products Categories Test

  Scenario: Create a new Product Category
    Given login for creating new  Product Category
    When create new  Product Category
    And verify that the Product Category is created and listed in the Products Category list
    Then close driver for creating Product Category

  Scenario: Edit a Product Category
    Given login for editing a Product Category
    When create new  Product Category
    When edit a Product Category
    And verify that the Product Category is edited
    Then close driver for editing Product Category

  Scenario: Verify functionality of a Product Category
    Given login for Verifying functionality of a Product Category
    When create new  Product Category
    When edit a Product Category
    When create a product
    And verify that the Product Category is there for product creation
    Then close driver for verifying Product Category