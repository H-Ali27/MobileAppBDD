@PrepaidAddPayee
Feature: Pay - Prepaid - Add Payee

  Scenario: User adds a prepaid payee and makes a payment
    Given the user is on the home screen
    When the user clicks on the 'Pay' button
    And the user clicks on 'Add Payee'
    And the user selects "Mobile-Prepaid" as the payment type
    And the user selects the mobile network category "UFONE-Prepaid"
    And the user enters the payee nickname "sza"
    And the user enters the payee mobile number "03352664286"
    And the user clicks the 'Next or Add' button
    And the user Review Details and click on the 'Next' button
    Then the user should see the OTP screen
    Then the user clicks on the okay button

