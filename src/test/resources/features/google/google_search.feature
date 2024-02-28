Feature: Google Search Functionality Title Validation
    User Story: As a user, when I am on the Google Search pagw
    I should be able to search whatever I want and see relevant info

    @google
    Scenario: Search functionality result title verification
        Given user is on Google search page
        When user types Loop Academy in the Google search box and clicks enter
        Then user should see Loop Academy - Google Search in the google title

    @google
    Scenario: Search functionality result title verification
        Given user is on Google search page
        When user types "Loop Academy" in the Google search box and clicks enter
        Then user should see "Loop Academy - Google Search" in the google title

    @google @smoke
    Scenario: Search functionality result title verification
        Given user is on Google search page
        When user types "Feyruz is java king" in the Google search box and clicks enter
        Then user should see "Feyruz is java king - Google Search" in the google title