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
 Then The user should able to see an "error message" in alert window
  
@StackTopics_ValidPython
Scenario Outline: Verify with valid python code of "<StackTopics>"
 Given the user is on the TryEditor page of "<StackTopics>"
 When the user input the valid python code and clicks run button
 Then the user should be able to see the output from the console   
 Examples:
   |StackTopics|
   |Implementation|
   |Applications|
    
@StackTopics_InValidPython
Scenario Outline: Verify with invalid python code of "<StackTopics>"
 Given the user is on the TryEditor page of "<StackTopics>"
 When the user input the invalid python code and clicks run button
 Then The user should able to see an "error message" in alert window
 Examples:
   |StackTopics|
   |Implementation|
   |Applications|
   
@StackTopics_PracticeQuestionslink 
Scenario Outline: Verify the user is able to check the brokenlink
    Given The user is on the topics page after clicking the "<StackTopics>"
    When The user clicks on the Practice Question link
    Then The user should be able to see the page is empty or not
  Examples:
   |StackTopics|
   |Implementation|
   |Applications|


