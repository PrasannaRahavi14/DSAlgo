Feature: Data Structures Page Validation

  Background:
    Given the user is in DataStructure page

@test236
  Scenario: verify the user is able to navigate to time complexity page
    When The user clicks the "Time Complexity" from the topics
    Then The user should be in "Time Complexity" Page

#  Scenario : verify the user is able to navigate to try editor page
#    Given The user is in the time complexity page
#    When The user click Try here button
#    Then The user should be redirected to the page having a try editor with run button
#
<<<<<<< HEAD
#  Scenario: Navigate to Time Complexity Page
#    Given The user is in "Data Structures Introduction" Page
#    When The user clicks the "Time Complexity" from the topics
#    Then The user is in "Time Complexity" Page

=======
#  Scenario : Verify the user is able to see the output for the valid python code
#    Given The user is in the try editor page
#    When The user enters the valid code and clicks run button
#    Then The user should be able to see the output in the console
>>>>>>> refs/remotes/origin/master
