@CardDelink
Feature: Card Management-Card DeLink

  Scenario: Users card management- card Delink
    Given the user is on the home screen
    When the user clicks on the Bread button
    And the user clicks on the card management tab
    And the user clicks on the card link delink button
    And the user clicks on the Account selection dropdown
    And the user clicks on the link delink button
    Then the user should see the OTP screen
    And the user clicks on the okay button
    And the user Back to Card screen
    And the user Back to home screen