@IFT
Feature: Instant Fund Transfer

  Scenario: User transfers funds via IFT
    Given the user is on the home screen
    When the user clicks on the Transfer button
    And the user selects Instant Fund Transfer
    And the user searches for "SADAPAY" in the bank list
    And the user enters the account number "03401201947"
    And the user enters the amount
    And the user selects the purpose of the transfer as "Educational Payment"
    And the user clicks on Review Details
    And the user clicks the 'Transfer Fund Now' button
    Then the user should see the OTP screen
    And the user clicks on Done to complete the transfer
    And the user is redirected to the home screen
