Feature: As a user, I want to be able to login to the application using email address and password

  @FirstTest
  Scenario: User should be able to launch the test application
    Given Appium server has been created and mobile device is ready
    Then The main activity should be <.MainActivity>