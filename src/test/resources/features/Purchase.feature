Feature: As a user, I want to be able to add few items to cart and proceed to payment

  Background: Test application has been launched successfully and user is already signed in

  @dev_Android @aut_Olawale
  @purchaseTest
  Scenario: User navigate to the home page and add the first items to cart
    Given user is already logged in
    And user clicks on the Sauce Labs Backpack item on the home page
    When user clicks on the Add To Cart button
    Then the the item is added to cart

  @dev_Android @aut_Olawale
  @purchaseTest
  Scenario: User add the second item to the cart
    Given user is on the product page
    And user clicks on the Bolt t-Shirt
#    When user clicks on the Add To Cart button
    Then the item is added to cart two items are confirmed in cart