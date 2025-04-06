Feature: As a user, I want to be able to login to the application using email address and password

  Background: Appium Server have been started successfully and test application have been launched

  @dev_Android @aut_Olawale
  @FirstTest
  Scenario: User navigate to the login page
    Given The user launches the app the appActivity should be ".MainActivity"
    Then User should be able to navigate to the login page

  Scenario Outline: User should not be able to log in with invalid credentials
    When The user tries to login with username as "<username>" and password as "<password>"
    Then There should be an error message "<errorMessage>" on the screen

    Examples:
      | username            | password | errorMessage                                                |
      |                     |          | Username is required                                        |
      |                     | 10203040 | Username is required                                        |
      | bob@example.com     |          | Password is required                                        |
      | john@killerbean.net | 10203040 | Provided credentials do not match any user in this service. |
      | bob@example.com     | password | Provided credentials do not match any user in this service. |

  Scenario: User should not be able to a locked out account
    When the user tries to login to a locked out account
    Then there should be an error message "Sorry, this user has been locked out." error

  Scenario: User should be able to login with the correct credentials
    When the user tries to login with a valid username as "bob@example.com" and valid password as "10203040"
    Then the should be directed to the home page of the application
