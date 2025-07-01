@RAASTPayID
Feature: RAAST Payment by ID

  Scenario: User transfers funds via RAAST ID
    Given the user is on the home screen
    When the user clicks on the RAAST button
    And the user clicks on the RAAST Payment button
    And the user clicks on Fund Transfer by RAAST ID
    And the user searches for RAAST type "MOBILE"
    And the user enters the account number "03401201947"
    And the user enters the amount
    And the user selects the purpose of transfer as "Donation"
    And the user clicks the next button
    And the user Review Details and click on the 'Transfer Fund Now' button
    Then the user should see the OTP screen
    And the user clicks on Done to complete the transfer
    And the user is redirected to the home screen
