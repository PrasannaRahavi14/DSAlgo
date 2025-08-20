@Array
  Feature: Testing Array page
    Background:
    Given User is in Array page after successful login

    @topicPage_1
      Scenario: Verify if the user is able to navigate to Array page
        When User clicks "Arrays in Python" hyperlink
        Then User should be redirected to "Arrays in Python" page

    @tryEditorPage_1
      Scenario: Verify if the user is able to navigate to try editor page
        Given User is on the Arrays in Python page after clicking "Arrays in Python"
        When User scrolls down to the bottom and click on Try here button
        Then User should be redirected to Try Editor page

    @validCode_1
      Scenario: Verify if the user is able to run valid python code
        Given User is on Try Editor page of the topic "Arrays in Python"
        When User enters valid python code and click Run
        Then User should be able to see the output

    @invalidCode_1
    Scenario: Verify if the user is able to run invalid python code
      Given User is on Try Editor page of the topic "Arrays in Python"
      When User enters invalid python code and click Run
      Then the user should see the error popup

    @practiceQuestionsPage_1_1
    Scenario: Verify if the user is able to navigate to Practice Questions page
      Given User is on the Arrays in Python page after clicking "Arrays in Python"
      When User clicks on Practice Questions hyperlink
      Then User should be redirected to Practice Questions page

    @practiceQuestionsPageOptions_1_1
    Scenario: Verify if the user is able to click the options in Practice Questions page
      Given User is in Practice Questions page under "Arrays in Python"
      When User clicks "Search the array" option in Practice Questions page
      Then User should be redirected to Run page

    @practiceQuestionsValidCode_1_1
    Scenario: Verify if the user is able to run valid python code in Practice Questions page
      Given User is on Run page under the Array topic "Arrays in Python" and Practice Questions option "Search the array"
      When User enters valid python code and click Run
      Then User should be able to see the output

    @practiceQuestionsInvalidCode_1_1
    Scenario: Verify if the user is able to run invalid python code in Practice Questions page
      Given User is on Run page under the Array topic "Arrays in Python" and Practice Questions option "Search the array"
      When User enters invalid python code and click Run
      Then the user should see the error popup