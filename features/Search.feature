@Debug
Feature: Search

  Background: open main page
    Given I'm on the Main page

  Scenario: Simple steps example
    When I select "6 June 2018" in the Check-in Date field on the Search Form
    When I select "18 June 2018" in the Check-out Date field on the Search Form
    And I check Business Purpose checkbox on the Search Form
    And I enter "Blue See Beach Resort" into Search text box on the Search Form
    And I select "1" in the Group Adults select on the Search Form
    And I click Submit button on the Search Form
    Then I see 16 hotel description blocs on the Search Results page
    And Hotel Name value of the 1 search result contains "Blue See Beach Resort"