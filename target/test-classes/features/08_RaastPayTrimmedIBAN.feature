@RaastPayTrimmedIBAN
Feature: RAAST Payment by Trimmed IBAN

  Scenario: User transfers funds via RAAST Trimmed IBAN
    When the user clicks on the RAAST button
    And the user clicks on the RAAST Payment button
    And the user clicks on Fund Transfer by trimmed IBAN
    And the user enters the Trimmed IBAN number "PK27BKIP0000011491408116"
    And the user enters the amount
    And the user selects the purpose of transfer as "Donation"
    And the user clicks the next button
    And the user Review Details and click on the 'Transfer Fund Now' button
    Then the user should see the OTP screen
    And the user clicks on Done to complete the transfer
    And the user is redirected to the home screen