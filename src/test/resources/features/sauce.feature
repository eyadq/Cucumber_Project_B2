Feature: Test sauce site for adding to cart and purchasing

  @ui @sauce
  Scenario: Add two items to cart and purchase them
    Given The user is signed in from the credentials from the login page
    And The user sorts items by "Price (low to high)"
    And The user adds the second item from each column
    And The user goes to the cart and clicks checkout
    And The user enters name and zip on next form and clicks continue
    And The user sees payment information and price
    And The user completes the order
    Then The user logs out