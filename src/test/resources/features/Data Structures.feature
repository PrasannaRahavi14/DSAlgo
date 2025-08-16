Feature: Data Structures Page Landing

  Background:
    Given the user is on Landing Page
    And the user signed in to ds algo page with username "Prasanna" and password "Welcome@01"

@test123
  Scenario: Navigate to Data Structures Page with button
    Given The user is in Home Page after login
    When The user clicks the Get Started Button of DS page
    Then The user is in "Data Structures-Introduction" Page

#  Scenario: Navigate to Data Structures Page with dropdown
#    Given The user is in Home Page after login
#    When The user clicks the option "Data Structures" from the dropdown
#    Then The user is in "Data Structures Introduction" Page
#
#  Scenario: Navigate to Time Complexity Page
#    Given The user is in "Data Structures Introduction" Page
#    When The user clicks the "Time Complexity" from the topics
#    Then The user is in "Time Complexity" Page

