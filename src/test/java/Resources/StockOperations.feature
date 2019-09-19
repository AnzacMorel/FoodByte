Feature: Stock operations

  Scenario: Add items to stock
    Given New stock items arrive
    When Add stock is selected
    And Data is entered
    And Confirm is selected
    Then Stock is added to the inventory

  Scenario: Remove items from stock
    Given Stock items expire are used etc
    When Remove stock is selected
    And Data is entered
    And Confirm is selected
    Then Stock is removed to the inventory

  Scenario: View current inventory levels
    Given A user needs to view stock levels
    When View inventory is selected
    Then List of all inventory items is displayed