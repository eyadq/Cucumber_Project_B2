Feature: Advisor Portal Rows Per Page Configuration

  @day20 @B2G1-260
  Scenario: Verify Rows Per Page Settings
    Given User logs into Docuport as "advisor"
    When the advisor navigates to the "Leads" section
    When the default Rows Per Page in "Leads" should be set to "10"
    When the advisor changes Rows Per Page to "5" in "Leads" section
    Then the Rows Per Page setting in "Leads" section should be updated to "5"
    When the advisor navigates to the "Users" section
    And the default Rows Per Page in "Users" section should be set to "10"
    When the advisor changes Rows Per Page to "5" in "Users" section
    Then the Rows Per Page setting in "Users" section should be updated to "5"

    @day20
  Scenario Outline: Verify Rows Per Page Settings
    Given User logs into Docuport as "<userType>"
    When the advisor navigates to the "Leads" section
    When the default Rows Per Page in "Leads" should be set to "10"
    When the advisor changes Rows Per Page to "5" in "Leads" section
    Then the Rows Per Page setting in "Leads" section should be updated to "5"
    When the advisor navigates to the "Users" section
    And the default Rows Per Page in "Users" section should be set to "10"
    When the advisor changes Rows Per Page to "5" in "Users" section
    Then the Rows Per Page setting in "Users" section should be updated to "5"
    Examples:
      |userType  |
      |advisor  |
      |supervisor  |