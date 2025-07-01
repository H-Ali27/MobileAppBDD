@BeneficiaryFundsTransfer

Feature: Beneficiary Funds Transfer

Scenario: User successfully transfers funds via Add beneficiary
  Given the user is on the home screen
  And the user navigates to the 'Beneficiary' section
  And the user clicks the 'Transfer' button
  And the user enters the transfer amount
  And the user selects the Purpose
  And the user clicks the 'Next' button
  And the user verifies the transaction details
  And the user clicks the 'Transfer Fund Now' button
  Then the user should see a status Success
  And the user clicks 'Done'
