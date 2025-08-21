Feature: Tree Page Validation

  Background:
    Given The user is in Tree Page after login

  Scenario: Get the total no of topics link in the Tree page
    When The user sees the topics covered section in Tree
    Then The user is able to get the total no of topics present in the page

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

  Scenario Outline: Verify the user is able to see the output for the "<input>" of the "<topics>"
    Given The user is in the try editor page of the Tree topic "<topics>"
    When The user enters "<input>" in the editor and clicks run button
    Then The user should be able to see the output for "<input>"
    Examples:
      | topics                         | input          |
      | Overview of Trees              |   ValidCode    |
      | Terminologies                  |  InvalidCode   |
      | Types of Trees                 |  AlphaNumeric  |
      | Tree Traversals                |   Numeric      |
      | Traversals-Illustration        |   ValidCode    |
      | Binary Trees                   |   InvalidCode  |
      | Types of Binary Trees          |  AlphaNumeric  |
      | Implementation in Python       |  Numeric       |
      | Binary Tree Traversals         |  ValidCode     |
      | Implementation of Binary Trees |  InvalidCode   |
      | Applications of Binary trees   |  AlphaNumeric  |
      | Binary Search Trees            |  Numeric       |
      | Implementation Of BST          |  ValidCode     |

  Scenario Outline: verify the user is able to check the broken link or empty page
    Given The user is in the topics page after clicking the "<topics>" link
    When The user clicks on the practice question link
    Then The user is able to check if the empty is empty or not

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