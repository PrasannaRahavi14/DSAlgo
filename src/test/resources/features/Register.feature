@Register: 

 Feature: User Registration in DSPortalapp 
 User will be able to register with username and password in DSPortalapp

  Background: The user is on Home Page
  
 @Register_linkvalidation
  Scenario: Landing on Register page 
   Given the user is on the Home page
   When the user clicks on Register link on the Home page
   Then The user should land on Register page.
 
 @Register_withEmptyfields
  Scenario: Register with all empty fields
   Given The user is on Register page after clicking on register link from homepage
   When the user clicks on Register button with all fields empty
   Then the user should see an error message as "Please fill out this field." below Username textbox
   
 @Register_withonlyUsername 
   Scenario: Register with only Username and remaining fields empty 
    Given The user is on Register page after clicking on register link from homepage
    When the user clicks on Register button after entering Username with other fields empty
    Then the user should see an error message as "Please fill out this field." below Password textbox
   
 @Register_withonlyPassword
   Scenario: Register with only Password and remaining fields empty  
    Given The user is on Register page after clicking on register link from homepage
    When the user clicks on Register button after entering Password with other fields empty
    Then the user should see an error message as "Please fill out this field." below Username textbox
     
 @Register_withoutPasswordConfirmation   
   Scenario: Register without Password confirmation 
    Given The user is on Register page after clicking on register link from homepage
    When the user clicks on Register button after entering Username and Password without Password confirmation
    Then the user should see an error message as "Please fill out this field." below Password confirmation textbox
     
 @Register_withMismatchPassword
   Scenario: Register with Mismatch Password  
    Given The user is on Register page after clicking on register link from homepage
    When the user clicks Register button after entering different passwords in Password and Password Confirmation fields 
    Then The user should able to see an pwd warning message "password_mismatch:The two password fields didn’t match."
  
 @Register_withValidCredentials
   Scenario: Register with Valid Credentials
    Given The user is on Register page after clicking on register link from homepage
    When the user clicks Register button with valid Username,Password and Password Confirmation
    Then The user should be redirected to Home Page of DS Algo with message "New Account Created. You are logged in as <ID>"

 @Register_withInvalidUsername
   Scenario: Register with Invalid Username
    Given The user is on Register page after clicking on register link from homepage
    When the user clicks Register button after entering Invalid data in Username field
    Then the user should see an warning message as "Username is not valid" below Username textbox
    
 @Register_withInvalidPassword
   Scenario: Register with Invalid Password
    Given The user is on Register page after clicking on register link from homepage
    When the user clicks Register button after entering a password with numeric values
    Then The user should see an warning message as "Your password can’t be entirely numeric." below password textbox
    
 @Register_Loginlinkvalidation
   Scenario: 
    Given The user is on Register page after clicking on register link from homepage
    When The user clicks the Login link in the register page
    Then The user should be redirected to Login page. 

   
  