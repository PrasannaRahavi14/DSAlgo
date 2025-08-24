
Feature: Testing Linked List Module

Background:
Given the user in Linked List page after signed in

@LLT01
Scenario Outline: Verify the user can able to land on different "<options>" page
When The user clicks on "<options>" link on Linked List module
Then The user should navigate to "<options>" page in Linked List module
Examples:

|options|
|Introduction|
|Creating Linked LIst|
|Types of Linked List|
|Implement Linked List in Python|
|Traversal|
|Insertion|
|Deletion|


@LLT02
Scenario Outline: Verify the user is able to navigate Try editor page for Linked List "<options>" module
Given The user clicks on "<options>" link on Linked List module
When  The user clicks on Try here button of "<options>" Page
Then  The user should be directed to Try editor page with run button of each "<options>" page

Examples:

|options|
|Introduction|
|Creating Linked LIst|
|Types of Linked List|
|Implement Linked List in Python|
|Traversal|
|Insertion|
|Deletion|

@LLT03
Scenario Outline: Verify the user is able to see the output for valid python code for all "<options>" in the Linked List module
Given The user is in try editor with "<options>" page from the Linked List module
When The user gives valid python code and clicks Run button from the Try editor
Then The user can able to see the output from the console window
Examples:

|options|
|Introduction|
|Creating Linked LIst|
|Types of Linked List|
|Implement Linked List in Python|
|Traversal|
|Insertion|
|Deletion|



@LLT04
Scenario Outline: Verifying the alert window displaying for every "<options>" within the Linked List module when invalid input is provided
Given The user is in try editor with "<options>" page from the Linked List module
When The user gives Invalid python code and clicks Run button from the Try editor
Then The user can able to see the alert window in the Linked list try editor page
Examples:

|options|
|Introduction|
|Creating Linked LIst|
|Types of Linked List|
|Implement Linked List in Python|
|Traversal|
|Insertion|
|Deletion|



@LLT05
Scenario:Scenario: Verify the user is able to check broken links or empty page in Linked List module
Given The user clicks on Introduction link from Linked List module
When The user clicks on practice questions link from Introduction page
Then The user can able to land on practice page to check valid or not



