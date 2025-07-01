@Logout
Feature: Logout Functionality

  Scenario: User logs out with confirmation
    Given User is logged in
    When the user clicks on the 'Logout' button
    And the user confirms the logout action
    Then the user should be redirected to the login screen
