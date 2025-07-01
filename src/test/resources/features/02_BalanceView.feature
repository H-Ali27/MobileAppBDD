@BalanceView
Feature: Balance Visibility Feature

  Scenario: User toggles balance visibility
    Given User is logged in
    When User taps on the balance view button
    Then Balance should be visible
    When User taps on the balance hide button
    Then Balance should be hidden