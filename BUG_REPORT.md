# BUG REPORT

## BUG: It's not able to add up to 4 strings at once

### Steps to reproduce
Add 4 strings at once to be counted, ex:
```java
new VowelConter().getVowelListWithCount(["Test", "Test", "Test", "Test"])
```
### Expected behavior
The vowel and consonants will be counted for each string

### Actual behavior
It's is returning a null pointer exception

### Console error
java.lang.NullPointerException: Cannot invoke "java.util.Collection.toArray()" because "c" is null

## BUG: It's not counting upperCase vowels

### Steps to reproduce
Add strings with UpperCase vowels, ex:
```java
new VowelConter().getVowelListWithCount(["Air", "Implementation"])
```
### Expected behavior
All the vowels should be counted, to "Air" it should count 2 vowels and to "Implementation" it should count 6 vowels

### Actual behavior
It's is counting 1 vowel to "Air" and 6 vowels to "Implementation"

## BUG: An error message is not being thrown when more than 4 strings are added at once

### Steps to reproduce
Add 5 strings at once, ex:
```java
new VowelConter().getVowelListWithCount(["Test", "Test", "Test", "Test", "Test"])
```
### Expected behavior
It's should throw a exception with the message "Extra arguments passed."

### Actual behavior
It's printing the message "Extra arguments passed."