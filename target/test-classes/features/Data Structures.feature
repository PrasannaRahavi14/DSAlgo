Feature: Data Structures Page Validation

  Background:
    Given the user is in DataStructure page after login

  Scenario: Get the total no of topics link in the DataStructure page
    When The user sees the topics covered section in Datastructure
    Then The user is able to get the total no of topics link present

  Scenario: verify the user is able to navigate to time complexity page
    When The user clicks the "Time Complexity" from the topics
    Then The user should be in "Time Complexity" Page

  Scenario: verify the user is able to navigate to try editor page
    Given The user is in the time complexity page after clicking "Time Complexity"
    When The user click Try here button
    Then The user should be redirected to the page having a try editor with run button

  Scenario Outline: Verify the user is able to see the "<input>"
    Given The user is in the try editor page of the topic "Time Complexity"
    When The user enters the "<input>" code and clicks run button
    Then The user should be able to see the output for the "<input>"
    Examples:
  | input       |
  | ValidCode   |
  | InvalidCode |
@DS005
  Scenario: verify the user is able to check broken links or empty page
    Given The user is in the time complexity page after clicking "Time Complexity"
    When The user clicks Practice Questions link
    Then The user should be able to check if the page is valid or not

