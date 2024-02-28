Feature: Practice soft assertions

  @soft
  Scenario: Soft assertions practice
    Given user is on Docuport login page
    #Then user validates "Login" text is displayed
    And user enters credentials
    |username |b1g1_client@gmail.com|
    |password |Group1               |
    #And user validates "choose account" text is displayed
    #And user clicks "continue" button
    And user clicks "Home" button
    And user clicks "Invitations" button
    And user valdates all soft assertions