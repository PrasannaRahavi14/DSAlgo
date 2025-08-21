Feature: User sigin to DSAlgo Portal

Background:
Given the user is on the Signin page

Scenario Outline: Failed login 
When the user clicks the Login button with "Error field"
Then the user should be displayed with error message
Examples:
|Error field|
| Missing username and password|
| Missing username|
| Missing Password|
| Invalid username|
| Invalid password|    


@pass
Scenario: Succesful login
When the user clicks the Login button after the valid "username" and "Password" is entered
Then the user will be directed to the Home Page with "You are logged in" message displayed