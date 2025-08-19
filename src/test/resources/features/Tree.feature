Feature: Tree Page Validation

  Background:
    Given The user is in Tree Page after login
@TR001
  Scenario Outline: verify the user is able to navigate to "<topics>" page
    When The user clicks the "<topics>" link from the topics
    Then The user should be in the "<topics>" Page of the Tree
  Examples:
    | topics                         |
    | Overview of Trees              |
    | Terminologies                  |
    | Types of Trees                 |
    | Tree Traversals                |
    | Traversals-Illustration        |
    | Binary Trees                   |
    | Types of Binary Trees          |
    | Implementation in Python       |
    | Binary Tree Traversals         |
    | Implementation of Binary Trees |
    | Applications of Binary trees   |
    | Binary Search Trees            |
    | Implementation Of BST          |

@TR002
  Scenario Outline: verify the user is able to navigate to try editor page of "<topics>"
    Given The user is in the topics page after clicking the "<topics>" link
    When The user click Try here button of the "<topics>" page
    Then The user should be redirected to the page having a try editor with run button of the current topic
    Examples:
      | topics                         |
      | Overview of Trees              |
      | Terminologies                  |
      | Types of Trees                 |
      | Tree Traversals                |
      | Traversals-Illustration        |
      | Binary Trees                   |
      | Types of Binary Trees          |
      | Implementation in Python       |
      | Binary Tree Traversals         |
      | Implementation of Binary Trees |
      | Applications of Binary trees   |
      | Binary Search Trees            |
      | Implementation Of BST          |

@TR003
  Scenario Outline: Verify the user is able to see the output for the valid python code of "<topics>"
    Given The user is in the try editor page of the Tree topic "<topics>"
    When The user inputs the valid python code and clicks run button
    Then The user should be able to see the output from the console
    Examples:
      | topics                         |
      | Overview of Trees              |
      | Terminologies                  |
      | Types of Trees                 |
      | Tree Traversals                |
      | Traversals-Illustration        |
      | Binary Trees                   |
      | Types of Binary Trees          |
      | Implementation in Python       |
      | Binary Tree Traversals         |
      | Implementation of Binary Trees |
      | Applications of Binary trees   |
      | Binary Search Trees            |
      | Implementation Of BST          |
