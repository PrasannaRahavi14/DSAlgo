@Array
  Feature: Testing Array page
    Background: User is in Array page
      Scenario: Verify if the user is able to navigate to Array page
        Given User is in Home page after successful sign-in
        When Click Get Started in the array or click on Data Structures dropdown to select Arrays
        Then User should be navigated to the Array page

    Scenario: Verify if the user is able to navigate to Array page
      Given User is on the Array page
      When User clicks Arrays in Python hyperlink
      Then User should be redirected to Arrays in Python page