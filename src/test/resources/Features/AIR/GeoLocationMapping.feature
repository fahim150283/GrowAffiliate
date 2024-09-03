Feature: Geo Location Mapping Test


  Scenario: Create a new  Geo Location Mapping
    Given login for creating new  Geo Location Mapping
    And create new  Geo Location Mapping
    Then close the Geo Location Mapping window

  Scenario: Search a  Geo Location Mapping for AIR
    Given Login to Search  Geo Location Mapping
    When search for Geo Location Mappings of an user and copy important elements from Geo Location Mapping
    Then close  Geo Location Mapping for search

  Scenario: copy the data for ordering by an user and verify
    Given Login to copy the data for ordering by an user
    When in create new order, copy the elements of order location
    Then close  Geo Location Mapping for verification
    And assert if the information is correct or not
