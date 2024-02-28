Feature: Passing multiple parameters to the same step


    Scenario: Searching multiple items
        Given user is on Google search page
        Then user searches for the following items
            |items|
            |loop academy|
        |java|
        |selenium|
        |cucumber bdd|
        |sql|
        |nadir|
        |zahid|
        |anna|
        |anything|


