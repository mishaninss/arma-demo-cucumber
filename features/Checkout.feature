
Feature: Checkout

@Desktop
  Scenario: One
    When I select "6 June 2018" in the Check-in Date field on the Search Form
        When I select "6 June sdfsdfsf" in the Check-in Date field on the Search Form
  Scenario: Two
    Then I click Submit button on the Search Form
