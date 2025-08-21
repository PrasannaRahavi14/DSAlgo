@Array
  Feature: Testing Array page
    Background:
    Given User is in Array page after successful login

    @topicPage_1
      Scenario Outline: Verify if the user is able to navigate to Array page
        When User clicks "<arrayTopic>" hyperlink
        Then User should be redirected to "<arrayTopic>" page
      Examples:
        | arrayTopic                |
        | Arrays in Python          |
        | Arrays Using List         |
        | Basic Operations in Lists |
        | Applications of Array     |

    @tryEditorPage_1
      Scenario Outline: Verify if the user is able to navigate to try editor page
        Given User is on the Arrays in Python page after clicking "<arrayTopic>"
        When User scrolls down to the bottom and click on Try here button
        Then User should be redirected to Try Editor page
      Examples:
        | arrayTopic                |
        | Arrays in Python          |
        | Arrays Using List         |
        | Basic Operations in Lists |
        | Applications of Array     |

    @validCode_1
      Scenario Outline: Verify if the user is able to run valid python code
        Given User is on Try Editor page of the topic "<arrayTopic>"
        When User enters valid python code and click Run
        Then User should be able to see the output
      Examples:
        | arrayTopic                |
        | Arrays in Python          |
        | Arrays Using List         |
        | Basic Operations in Lists |
        | Applications of Array     |

    @invalidCode_1
    Scenario Outline: Verify if the user is able to run invalid python code
      Given User is on Try Editor page of the topic "<arrayTopic>"
      When User enters invalid python code and click Run
      Then the user should see the error popup
      Examples:
        | arrayTopic                |
        | Arrays in Python          |
        | Arrays Using List         |
        | Basic Operations in Lists |
        | Applications of Array     |

    @practiceQuestionsPage_1_1
    Scenario Outline: Verify if the user is able to navigate to Practice Questions page
      Given User is on the Arrays in Python page after clicking "<arrayTopic>"
      When User clicks on Practice Questions hyperlink
      Then User should be redirected to Practice Questions page
      Examples:
        | arrayTopic                |
        | Arrays in Python          |
        | Arrays Using List         |
        | Basic Operations in Lists |
        | Applications of Array     |

    @practiceQuestionsPageOptions_1_1
    Scenario Outline: Verify if the user is able to click the options in Practice Questions page
      Given User is in Practice Questions page under "<arrayTopic>"
      When User clicks "<practiceQuestions>" option in Practice Questions page
      Then User should be redirected to Run page
      Examples:
        | arrayTopic                | practiceQuestions                       |
        | Arrays in Python          | Search the array                        |
        | Arrays in Python          | Max Consecutive Ones                    |
        | Arrays in Python          | Find Numbers with Even Number of Digits |
        | Arrays in Python          | Squares of  a Sorted Array              |
        | Arrays Using List         | Search the array                        |
        | Arrays Using List         | Max Consecutive Ones                    |
        | Arrays Using List         | Find Numbers with Even Number of Digits |
        | Arrays Using List         | Squares of  a Sorted Array              |
        | Basic Operations in Lists | Search the array                        |
        | Basic Operations in Lists | Max Consecutive Ones                    |
        | Basic Operations in Lists | Find Numbers with Even Number of Digits |
        | Basic Operations in Lists | Squares of  a Sorted Array              |
        | Applications of Array     | Search the array                        |
        | Applications of Array     | Max Consecutive Ones                    |
        | Applications of Array     | Find Numbers with Even Number of Digits |
        | Applications of Array     | Squares of  a Sorted Array              |

    @practiceQuestionsValidCode_1_1
    Scenario Outline: Verify if the user is able to run valid python code in Practice Questions page
      Given User is on Run page under the Array topic "<arrayTopic>" and Practice Questions option "<practiceQuestions>"
      When User enters valid python code and click Run
      Then User should be able to see the output
      Examples:
        | arrayTopic                | practiceQuestions                       |
        | Arrays in Python          | Search the array                        |
        | Arrays in Python          | Max Consecutive Ones                    |
        | Arrays in Python          | Find Numbers with Even Number of Digits |
        | Arrays in Python          | Squares of  a Sorted Array              |
        | Arrays Using List         | Search the array                        |
        | Arrays Using List         | Max Consecutive Ones                    |
        | Arrays Using List         | Find Numbers with Even Number of Digits |
        | Arrays Using List         | Squares of  a Sorted Array              |
        | Basic Operations in Lists | Search the array                        |
        | Basic Operations in Lists | Max Consecutive Ones                    |
        | Basic Operations in Lists | Find Numbers with Even Number of Digits |
        | Basic Operations in Lists | Squares of  a Sorted Array              |
        | Applications of Array     | Search the array                        |
        | Applications of Array     | Max Consecutive Ones                    |
        | Applications of Array     | Find Numbers with Even Number of Digits |
        | Applications of Array     | Squares of  a Sorted Array              |

    @practiceQuestionsInvalidCode_1_1
    Scenario Outline: Verify if the user is able to run invalid python code in Practice Questions page
      Given User is on Run page under the Array topic "<arrayTopic>" and Practice Questions option "<practiceQuestions>"
      When User enters invalid python code and click Run
      Then the user should see the error popup
      Examples:
        | arrayTopic                | practiceQuestions                       |
        | Arrays in Python          | Search the array                        |
        | Arrays in Python          | Max Consecutive Ones                    |
        | Arrays in Python          | Find Numbers with Even Number of Digits |
        | Arrays in Python          | Squares of  a Sorted Array              |
        | Arrays Using List         | Search the array                        |
        | Arrays Using List         | Max Consecutive Ones                    |
        | Arrays Using List         | Find Numbers with Even Number of Digits |
        | Arrays Using List         | Squares of  a Sorted Array              |
        | Basic Operations in Lists | Search the array                        |
        | Basic Operations in Lists | Max Consecutive Ones                    |
        | Basic Operations in Lists | Find Numbers with Even Number of Digits |
        | Basic Operations in Lists | Squares of  a Sorted Array              |
        | Applications of Array     | Search the array                        |
        | Applications of Array     | Max Consecutive Ones                    |
        | Applications of Array     | Find Numbers with Even Number of Digits |
        | Applications of Array     | Squares of  a Sorted Array              |
