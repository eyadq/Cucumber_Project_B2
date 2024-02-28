Feature: Create new client as advisor and login as that client

  @ui @db @B2G1-247 @smitty
  Scenario: Create a client account and login as that account
    Given User logs into Docuport as "advisor"
    And user creates new client
    And User logs out of Docuport
    And User logs into Docuport as "smitty"
    And User logs out of Docuport
    Then new account is deleted


