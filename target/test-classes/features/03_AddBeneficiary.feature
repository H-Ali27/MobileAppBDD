@AddBeneficiary
Feature: Add Beneficiary to Bank Account

  Scenario: User adds a new beneficiary successfully
    Given the user is on the home screen
    And the user navigates to the 'Beneficiary' section
    And the user adds the beneficiary
    And the user selects the bank
    And the user enters the account number
    And the user clicks the next button
    And the user waits for the OTP and enters the nickname
    And the user clicks on 'Add Beneficiary' Button
    Then the user should see a confirmation message 'Beneficiary added successfully' and click Ok
    And the user navigates to the home screen