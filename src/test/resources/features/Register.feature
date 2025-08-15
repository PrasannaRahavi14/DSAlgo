Feature: <Feature Title>
  As a user
  I want <some goal>
  So that <some benefit>

  Background:
    Given the application is running
    And the user is on the login page

  Scenario: Successful login
    Given the user enters a valid username and password
    When the user clicks the login button
    Then the user should be redirected to the dashboard

  Scenario: Invalid login
    Given the user enters an invalid password
    When the user clicks the login button
    Then an error message should be displayed...
