Feature: Verify Left hand side navigation menu items

  @navigationMenu @navigationMenuClient @B2G1-241
  Scenario Outline: Verify Left hand side navigation menu items
    Given User logs into Docuport as "<userType>"
    Then Verify the user has the following items in the left navigation drawer for user "<userType>"
      | client     | Home | Received docs | My uploads | Invitations |             |             |             |                 |                 |                 |
      | supervisor | Home | Received docs | My uploads | Clients     | Users       | Leads       | Bookkeeping | 1099 Form       | Reconciliations |                 |
      | advisor    | Home | Received docs | My uploads | Clients     | Invitations | Users       | Leads       | Bookkeeping     | 1099 Form       | Reconciliations |
      | employee   | Home | Received docs | My uploads | Clients     | Users       | Bookkeeping | 1099 Form   | Reconciliations |                 |                 |
    Examples:
      | userType   |
      | client     |
      | employee   |
      | supervisor |
      | advisor    |
