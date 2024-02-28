Feature: Wikipedia Search Functionality Verification

  @ui @wikipedia @B2G1-193 @B2G1-212
  Scenario: Title Verification
    Given the user is on the Wikipedia home page.
    When the user types "Steve Jobs" in the wiki search box.
    And the user clicks the wiki search button.
    Then the user should see the page with "Steve Jobs" in the wiki title.

  @ui @wikipedia  @B2G1-194 @B2G1-213
  Scenario: Header Verification
    Given the user is on the Wikipedia home page.
    When the user types "Steve Jobs" in the wiki search box.
    And the user clicks the wiki search button.
    Then the user should see the page with "Steve Jobs" in the main header.