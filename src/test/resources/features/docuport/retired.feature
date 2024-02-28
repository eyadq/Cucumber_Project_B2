Feature: Old scenarios

@retired @B2G1-165 @B2G1-184 @B2G1-190
Scenario: Login as a client
Given user is on Docuport login page for "client"
When user enters username for "client"
And user enters password for "client"
And user clicks login button for "client"
Then user should see the home page for "client"

@retired @dataTableMap
Scenario: Login as a client map practice
When user enters credentials
| username | b1g1_client@gmail.com |
| password | Group1                |
Then user should see the home page for "client"