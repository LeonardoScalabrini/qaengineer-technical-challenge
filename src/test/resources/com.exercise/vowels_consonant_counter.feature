Feature: As a user I want to be able to add a list of strings
  and see the number of vowels and consonant in each of the strings

  Scenario: Counting vowels strings
    Given I add the following strings
      |0|1|2|3|
      |"AeIoUa"|"uiOa"|"OAe"|"EAiOuAeIoU"|
    When I count the vowels and consonants in the strings
    Then I should see the following output
      | string       |vowels|consonants|
      |"AeIoU"       | 6    | 0        |
      |"uiOa"        | 4    | 0        |
      |"OAe"         | 3    | 0        |
      |"EAiOuAeIoU"  | 10   | 0        |

  Scenario: Counting consonants strings
    Given I add the following strings
      |0|1|2|3|
      |"BceFr"|"Ghtvp"|"xzNMlp"|"kqwSd"|
    When I count the vowels and consonants in the strings
    Then I should see the following output
      | string       |vowels|consonants|
      |"BceFr"       | 0    | 5        |
      |"Ghtvp"       | 0    | 5        |
      |"xzNMlp"      | 0    | 6        |
      |"kqwSd"       | 0    | 5        |

  Scenario: Counting vowels and consonants in strings
    Given I add the following strings
      |0|1|2|3|
      |""||||
      |"Java"||||
      |"World"|"Cucumber"|||
      |"Test"|"Scenarios"|"Other"||
      |"Condition"|"Analyze"|"Array"|"Strings"|
    When I count the vowels and consonants in the strings
    Then I should see the following output
      | string       |vowels|consonants|
      |"Java"        | 2    | 3        |
      |"World"       | 1    | 3        |
      |"Cucumber"    | 3    | 5        |
      |"Test"        | 1    | 3        |
      |"Scenarios"   | 4    | 5        |
      |"Other"       | 2    | 3        |
      |"Condition"   | 4    | 5        |
      |"Analyze"     | 3    | 4        |
      |"Array"       | 2    | 3        |
      |"Strings"     | 1    | 6        |

  Scenario: Counting vowels and consonants in sentence strings
    Given I add the following strings
      |0|1|2|3|
      |"Java, World!"|"World Cucumber 123"|"1Test12 @S!cenarios15 Other"|"Co12nditi&on 12 An12al@yze, Array. Strings"|
    When I count the vowels and consonants in the strings
    Then I should see the following output
      | string                                     |vowels|consonants|
      |"Java, World!"                              | 3    | 6        |
      |"World Cucumber 123"                        | 4    | 8        |
      |"1Test12 @S!cenarios15 Other"               | 7    | 11       |
      |"Co12nditi&on 12 An12al@yze, Array. Strings"| 10    | 18      |

  Scenario: Adding more the 4 strings
    Given I add the following strings
      |0|1|2|3|4|
      |"Java"|"World"|"Test"|"Other"|"Strings"|
    Then I should see the error message