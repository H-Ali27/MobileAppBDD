@RaastPayByIBFTBeneficiary
Feature: RAAST Payment by adding IBFT Beneficiary

  Scenario: User transfers funds via RAAST after adding a beneficiary
    When the user clicks on the RAAST button
    And the user clicks on the RAAST Beneficiary button
    And the user adds the beneficiary
    And the user selects the RAAST type 'RAAST IBAN'
    And the user enters the RAAST IBAN number "PK31UNIL0109000278809659"
    And the user clicks the next button
    And the user should see the OTP screen
    And the user enters the nickname "Burhan" and clicks the add beneficiary button
    And the user clicks on the okay button
    And the user navigates to the RAAST Screen
    And the user clicks on the RAAST Payment button
    And the user clicks on Fund Transfer by beneficiary
    And the user searches for the beneficiary "Burhan" and selects it
    And the user enters the amount
    And the user selects the purpose of transfer as "Donation"
    And the user clicks the next button
    And the user Review Details and click on the 'Transfer Fund Now' button
    And the user clicks on Done to complete the transfer
    And the user is redirected to the home screen
