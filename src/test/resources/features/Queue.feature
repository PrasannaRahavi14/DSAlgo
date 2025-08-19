   
   Feature: Testing Queue Page in Ds-Algo    
     
  Background: Given the user is signed in to DsAlgo page
              When the user clicks the "Get Started" button under "Queue" 
              Then the user should be directed to "Queue" page
    
    @queue
    Scenario: Verify that the "Implementation of Queue in Python" is displayed
    When the user clicks "Implementation of Queue in Python" hyperlink
    Then the user should be directed to the next page

    @tryhere
    Scenario: Verify "Tryhere" navigates to next page
    Given the user is on "Implementation of Queue in Python" Page
    When the user clicks on "Tryhere" button
    Then the user is displayed with editor page
    
    @Code
    Scenario: Verify Python code works
    Given the user is in "Editor" Page
    When the user enters the valid python code and clicks "Run"
    Then the user is dispalyed with the code
    
    @invalidcode
    Scenario: Verify Invalid Python code works
    When the user enters invalid python data 
    Then the user should see error popup "xyz not defined in line 1" 
    
    @valid
    Scenario Outline: User is on Queue Page after Signed in with valid python code
    Given the user is on Queue Page
    When the user clicks "<pass>"
    Then the user is redirected to the next page
    
    Examples:
    |pass|
    |Implementation using collections deque|
    |Implementation using Array|
    |Queue operations|
    
    @invalid
    Scenario Outline: User is on Queue Page after Signed in with Invalid python code
    When the user clicks "<fail>" on Queue page
    Then the user is in next page
    
    Examples:
    |fail|
    |Implementation using collections deque|
    |Implementation using Array|
    |Queue operations|
    