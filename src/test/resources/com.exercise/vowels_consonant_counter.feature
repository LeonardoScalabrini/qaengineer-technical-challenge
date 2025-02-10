Feature: As a user I want to be able to add a list of strings
  and see the number of vowels and consonant in each of the strings

  Scenario: Counting vowels and consonants in strings
    Given I add the following strings
      |0|1|2|3|
      |""||||
    When I count the vowels and consonants in the strings
    Then I should see the following output
      | string     |vowels|consonants|
      |""          | 0    | 0        |
