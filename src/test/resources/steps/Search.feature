Feature: Search

  Background: open main page
    Given I'm on the Main page

  Scenario: Simple steps example
    When I enter "Blue See Beach Resort" into Search text box on the Search Form
    And I select "1 adult" in the Group Adults select on the Search Form
    And I check Business Purpose checkbox on the Search Form
    And I click Submit button on the Search Form
    Then I see 22 hotel description blocs on the Search Results page
    And Hotel Name value of the 1 search result contains "Blue See Beach Resort"



