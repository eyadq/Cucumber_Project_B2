Feature: Docuport Login Logout Feature

  @loginOutline
  Scenario Outline: Login to Docuport
    Given User logs into Docuport as "<userType>"
    Examples:
      | userType   |
      | client     |
      | employee   |
      | supervisor |
      | advisor    |

  @logoutOutline
  Scenario Outline: Log out of Docuport
    Given User logs into Docuport as "<userType>"
    Then User logs out of Docuport
    Examples:
      | userType   |
      | client     |
      | employee   |
      | supervisor |
      | advisor    |

  @login
  Scenario: Login to Docuport
    Given User logs into Docuport as "supervisor"

  @logout
  Scenario: Logout from Docuport
    Given User logs into Docuport as "client"
    Then User logs out of Docuport


