@Login
Feature: Login to the Mobile Banking App

  Scenario: User successfully logs in with valid credentials
    Given User is on the login screen
    When the user enters username "Syedaffan0412"
    And the user enters password "Aff@n_091497"
    And User taps on login button
    Then User should be logged in successfully

