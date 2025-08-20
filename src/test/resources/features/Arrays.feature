@Array
  Feature: Testing Array page
    Background:
    Given User is in Array page after successful login

    @array1
      Scenario: Verify if the user is able to navigate to Array page
        When User clicks "Arrays in Python" hyperlink
        Then User should be redirected to "Arrays in Python" page

    @array2
      Scenario: Verify if the user is able to navigate to try editor page
        Given User is on the Arrays in Python page after clicking "Arrays in Python"
        When User scrolls down to the bottom and click on Try here button
        Then User should be redirected to Try Editor page

    @array3
      Scenario: Verify if the user is able to run valid python code
        Given User is on Try Editor page of the topic "Arrays in Python"
        When User enters valid python code and click Run
        Then User should be able to see the output

    @array4
    Scenario: Verify if the user is able to run invalid python code
      Given User is on Try Editor page of the topic "Arrays in Python"
      When User enters invalid python code and click Run
      Then the user should see the error popup