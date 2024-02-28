Feature: Verify toolbar on received documents

  @ui @toolbarElements @B2G1-249
  Scenario Outline: Verify toolbar on received documents
    Given User logs into Docuport as "<userType>"
    When User navigates to "Received docs"
    Then User verifies "<Received docs>" elements
      | Search | Download | Received docs |
    When User navigates to "My uploads"
    Then User verifies "<My uploads>" elements
      | Search | Download | My uploads |
    Examples:
      | userType   |
      | client     |
      | employee   |
      | supervisor |
      | advisor    |