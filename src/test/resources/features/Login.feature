Feature: As a user, I want to be able to login to the application using email address and password

  Background: Appium Server have been started successfully and test application have been launched

  @FirstTest
  Scenario: User should be able to launch the test application
    When The user launches the app the appActivity should be ".MainActivity"
    And User should be able to navigate to the login page

    Scenario: User should not be able to login with incorrect or blank credentials
      When The user tries to login with blank credentials
      Then There should be an error message "Username is required" on the screen