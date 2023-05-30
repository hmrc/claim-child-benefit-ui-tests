@Regression
Feature: Journeys for completing the Child Claim form and generating a PDF

  Background:
    Given I am on the start page
    When Enter Applicant NI Number

  Scenario Outline:  As a Single parent whose earning over £50kpa, who does not currently receive CHB can submit Application and generate PDF
  Single parent journey, earning over £50kpa, who does not currently receive CHB
    Then I completed the Applicant section with details firstname <firstname> lastname <lastname> and family previous name <familyPreviousName>
    And  I navigate to the Relationship details and selected relationship
    When I navigate to child details page and completed the child details with <firstname> and <lastname>
    And  Adding the second child details with <secondCHFirstName> and <secondCHSecondName>
    And  Adding the third child details with <thirdCHFName> and <thirdCHSName>
    And  Adding the Income details
    And  Accept and Declare the Terms and Conditions
    Then Download the PDF
    And  the PDF extracted and validated the data against the given form values during submission:
      | BOO              |
      | FOO              |
      | +44 161 210 3086 |
      | 0300 200 3100    |

    Examples:
      | firstname | lastname | familyPreviousName | secondCHFirstName | secondCHSecondName | thirdCHFName | thirdCHSName |
      | Boo       | Foo      | zoo                | Booo              | Fooo               | Boooo        | Foooo        |


