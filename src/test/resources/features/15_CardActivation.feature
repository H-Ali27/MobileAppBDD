@CardActivation
Feature: Card management-Card Activation

  Scenario: User card management- card Activation
    Given the user is on the home screen
    When the user clicks on the Bread button
    And the user clicks on the card management tab
    When the user clicks on the card Activation button
    And the user clicks on the Yes button
    Then the user should see the OTP screen
    And the user clicks on the okay button on confirmation
    And the user Back to home screen
