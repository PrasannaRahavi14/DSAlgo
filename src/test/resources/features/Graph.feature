Feature: Validate Graph Page functionality in Ds-Algo

  Background:
    Given the user has signed in and navigated to the Graph page

  @valid
  Scenario Outline: Accessing Graph topics with valid Python code
    When the user selects "<option>" from the Graph page
    Then the user should be redirected to the "<option>" page

    Examples:
      | option               |
      | Graph                |
      | Graph Representations |

  @invalid
  Scenario Outline: Accessing Graph topics with invalid Python code
    When the user selects "<option>" from the Graph page
    Then the user should remain on the "<option>" page with an error

    Examples:
      | option               |
      | Graph                |
      | Graph Representations |
