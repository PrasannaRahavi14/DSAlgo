Feature: Stack Page Validation

Background:
Given the user is on the Stack Page

@Operationinstackpage
Scenario: Navigate to Operations in Stack page
 When the user clicks on "Operations in Stack" link
 Then the user The user should be redirected to "Operations in Stack" page

@Tryeditorvalidation
Scenario: Navigate to Try Editor page
 Given the user is on "Operations in Stack" page
 When the user clicks the Try Here button on operations in stackpage
 Then the user should be redirected to a page having an try Editor with a Run button to test
 
 @Validpythoncode
 Scenario: Verifing with valid python code for "Operations in stack" page
  Given the user is on TryEditor page of "Operations in stack"
  When the user write the valid code in Editor and click the "Run" button
  Then The user should able to see output in the console below
 
 @Invalidpythoncode
 Scenario: Verifing with invalid python code for "Operations in stack" page
  Given the user is on TryEditor page of "Operations in stack"
  When the user write the invalid code in Editor and click the "Run" button
  Then TThe user should able to see an "error message" in alert window
 


