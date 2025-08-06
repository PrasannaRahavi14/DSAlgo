@Register: 

 Feature: User Registration in DSPortalapp 
 User will be able to register with username and password in DSPortalapp

  Background: Home Page of DSPortalapp
  
  Scenario: Landing on Register page 
   Given the user is on the Home page
   When the user clicks on Register link on the Home page
   Then the user should be redirected to the Register page

  Scenario: Register with all empty fields
    Given the user is on the Register page
    When the user clicks on Register button with all fields empty
    Then the user should see an error message as "Please fill out this field." below Username textbox
    
  Scenario: Register with only Username and remaining fields empty 
    Given the user is on the Register page
    When the user clicks on Register button after entering Username with other fields empty
    Then the user should see an error message as "Please fill out this field." below Password textbox
   
   Scenario: Register with only Password and remaining fields empty  
     Given the user is on the Register page
     When the user clicks on Register button after entering Password with other fields empty
     Then the user should see an error message as "Please fill out this field." below Username textbox
     
   Scenario: Register without Password confirmation 
     Given the user is on the Register page
     When the user clicks on Register button after entering Username and Password without Password confirmation
     Then the user should see an error message as "Please fill out this field." below Password confirmation textbox
