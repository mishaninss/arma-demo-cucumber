@InProgress
Feature: Checkout

  @Desktop
  Scenario: One
    When I select "6 June 2018" in the Check-in Date field on the Search Form
    When I select "6 June sdfsdfsf" in the Check-in Date field on the Search Form
  
  @Desktop
  Scenario: Two
    Then I click Submit button on the Search Form
    When I select "8 June 2018" in the Check-in Date field on the Search Form
    Then I'm on the Main page
    And Hotel Name value of the 1 search result contains "Blue See Beach Resort"
    When I'm on the Main page
    
   
    
