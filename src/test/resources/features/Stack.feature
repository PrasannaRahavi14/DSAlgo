Feature: Stack Page Validation

Background:
Given the user is on the Stack Page

@Stack_001
Scenario: Navigate to Operations in Stack page
 When the user clicks on "Operations in Stack" link
 Then the user The user should be redirected to "Operations in Stack" page

@Stack_002
Scenario: Navigate to Try Editor page
 Given the user is on Operations in Stack page
 When the user clicks "Try Here" button
 Then the user should be redirected to a page having an try Editor with a Run button to test


