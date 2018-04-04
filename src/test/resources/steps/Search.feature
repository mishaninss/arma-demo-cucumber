@Debug
Feature: Search

  Background: open main page
    Given I'm on the Main page

  Scenario: Simple steps example
    When I enter "Blue See Beach Resort" into Search text box on the Search Form
    And I select "1" in the Group Adults select on the Search Form
    And I check Business Purpose checkbox on the Search Form
    And I click Submit button on the Search Form
    Then I see 16 hotel description blocs on the Search Results page
    And Hotel Name value of the 1 search result contains "Blue See Beach Resort"

  Scenario: Abstract steps example
    When I change value of "search" element on the Search Form to "Blue See Beach Resort"
    And I change value of "group adults" element on the Search Form to "1 adult"
    And I change value of "business purpose" element on the Search Form to "true"
    And I click on "submit" element on the Search Form

  Scenario: Batch steps example
    When I fill the Search Form with values:
      | search           | Blue See Beach Resort |
      | group adults     | 1 adult               |
      | business purpose | true                  |
    And I click on "submit" element on the Search Form


