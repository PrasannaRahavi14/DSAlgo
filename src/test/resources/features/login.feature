Feature: User sigin to DSAlgo Portal

Background:
Given the user is on the Signin page

@fail
Scenario: Failed login due to empty username and password
When the user clicks "Login" button 
Then the error message should be displayed

@fail1
Scenario: Failed Login due to Username missing
When the user clicks the "Login" button without entering username field
Then the user should be displayed with error message "Please fill out this field"

@fail2
Scenario: Failed Login due to password missing
When the user clicks the "login" button without entering password field
Then the user should be displayed with error message "Please fill out this field"

@fail3
Scenario: Failed Login due to incorrect Username
When the user clicks the "Login" button after the invalid Username is entered
Then the error message "Invalid Username and Password" should be displayed

@fail4
Scenario: Failed Login due to incorrect password
When the user clicks the "Login" button after the invalid Password is entered
Then the error message "Invalid Username and Password" should be displayed

@pass
Scenario: Succesful login
When the user clicks the Login button after the valid "username" and "Password" is entered
Then the user will be directed to the Home Page with "You are logged in" message displayed