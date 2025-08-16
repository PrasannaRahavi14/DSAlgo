
@tag
Feature: Homepage test


@TC01
Scenario: Verify Home page Title
Given The user is on dsAlgo portal page
When The user click Get started button
Then The user should be redireced to Home page to verify NumbyNinja 


@TC02
Scenario: Verify the Register element is displayed in Register page
Given The user is on the Home page
When the user clicks Register button
Then The user should be redirected to Register page to verify register button


@TC03
Scenario: Verify Sign in element is displayed in Sign in page
Given The user is on the Home page
When the user clicks Sign in button
Then The user should be redirected to sign in page to verify element displayed or not


Scenario Outline: User is on Home page and click getstarted link "<option>" on home page without sign in
    Given The user is on the Home page
    When The user clicks on Get Started link on homepage "<option>" without login
    Then The user get warning message "You are not logged in"
    Examples:
      | option         |
      | Datastructures |
      | Array         |
      | Linkedlist     |
      | Stack          |
      | Queue          |
      | Tree           |
      | Graph          |
      
  Scenario Outline: Verify the user is able to click on "<option>" from dropdown on home page without Sign in
    Given The user is on the Home page
    When The user clicks on "<option>" from dropdown on home page without Sign in
    Then The user get warning message "You are not logged in" 
    Examples:
    
      | option         |
      | Array         |
      | Linkedlist     |
      | Stack          |
      | Queue          |
      | Tree           |
      | Graph          |
      

Scenario Outline:: Verify "<module>" page after sign in 
Given The user successfully sign in "dummyuser" and "numpy@123"
When The user clicks "Get Started" button under "<module>" page
Then The user should be directed to "<module>" page to verify the title
Examples:

       | module        |
      | Datastructures |
      | Array         |
      | Linkedlist     |
      | Stack          |
      | Queue          |
      | Tree           |
      | Graph          |  
      
      
Scenario Outline: Verify the user is able to click on "<module>" from dropdown on home page after Sign in
    Given  The user successfully sign in "dummyuser" and "numpy@123"
    When The user clicks on "<module>" from dropdown on home page after Sign in
    Then The user should be directed to "<module>" page to verify the title
    Examples:
    
      | module         |
      | Array         |
      | Linkedlist     |
      | Stack          |
      | Queue          |
      | Tree           |
      | Graph          |         

Scenario: Verify Successfull SignOut message
Given The user successfully sign in "dummyuser" and "numpy@123" 
When  The user click on Sign Out button from home page
Then The user can able to see "Logged out successfully" message
  








