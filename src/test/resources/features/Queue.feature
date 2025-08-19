   
   Feature: Testing Queue Page in Ds-Algo    
     
  Background:
   Given the user is on Queue page after Sign in
              
              
    @valid
    Scenario Outline: User is on Queue Page after Signed in with valid python code
    When the user clicks "<options>" on Queue Page
    Then the user is redirected to the "<options>" page
    
    Examples:
    |options|
    |Implementation of Queue in python|
    |Implementation using collections deque|
    |Implementation using Array|
    |Queue operations|
    
    @invalid
    Scenario Outline: User is on Queue Page after Signed in with Invalid python code
    When the user clicks "<options>" from Queue page
    Then the user is in "<options>" page
    
    Examples:
    |options|
    |Implementation of Queue in python|
    |Implementation using collections deque|
    |Implementation using Array|
    |Queue operations|
    