Feature: Testing of travel site

  Scenario: Booking a tour
    Given Open the browser
    When Navigate to the travel website
    And Verify the page title as Home Page | Mail Travel is displayed on UI
    Then Click on Accept All Cookies
    And Search for India in search bar and click on the search button
    When User selects holiday package
    When User selects two passenger from the dropdown
    And User selects a departure date from the calendar
    Then User should see the tour price

