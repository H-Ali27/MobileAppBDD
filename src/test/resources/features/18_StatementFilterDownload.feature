@StatementFilterDownload
Feature: Statement Filter and Download

  Scenario: User filters and downloads account statement
    Given the user is on the home screen
    When the user clicks on the Statement button
    And the user clicks on the See all button
    And the user clicks on the Calender button
    And the user selects the date range from '18/03/2025' to '17/04/2025'
    And the user clicks on the Calender okay button
    Then the filtered transactions should be displayed
    When the user clicks on the Download button
    And the user clicks on the okay button
    And the user Back to home screen

