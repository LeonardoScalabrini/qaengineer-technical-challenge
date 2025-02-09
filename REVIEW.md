# Code Review

## CountResult.java

[private String word;](https://github.com/LeonardoScalabrini/qaengineer-technical-challenge/blob/22619419459a370d6bd01e63009d1420fda93221/src/main/java/com/exercise/CountResult.java#L4)

Suggestion: Mark the field as final for immutability good pratice

[private Integer vowelCount;](https://github.com/LeonardoScalabrini/qaengineer-technical-challenge/blob/22619419459a370d6bd01e63009d1420fda93221/src/main/java/com/exercise/CountResult.java#L5)

Suggestions: Mark the field as final for immutability good pratice and use int intead of Integer to avoid unnecessary boxing

[public void setVowelCount](https://github.com/LeonardoScalabrini/qaengineer-technical-challenge/blob/22619419459a370d6bd01e63009d1420fda93221/src/main/java/com/exercise/CountResult.java#L16)

Suggestion: With the final on the field this method can be removed

[public void setWord(String word)](https://github.com/LeonardoScalabrini/qaengineer-technical-challenge/blob/22619419459a370d6bd01e63009d1420fda93221/src/main/java/com/exercise/CountResult.java#L24)

Suggestion: With the final on the field this method can be removed

[equals() and hashCode()]()

Suggestion: Override the equals and hashCode methods to ensure the correct behavior in HashMap and Collections methods

## VowelCounter

[public class VowelCounter](https://github.com/LeonardoScalabrini/qaengineer-technical-challenge/blob/22619419459a370d6bd01e63009d1420fda93221/src/main/java/com/exercise/VowelCounter.java#L7)

Suggestion: Since this class doesn't require attributes, we could implement the Singleton design pattern to prevent unnecessary instances

[if (args.length >= 4)](https://github.com/LeonardoScalabrini/qaengineer-technical-challenge/blob/22619419459a370d6bd01e63009d1420fda93221/src/main/java/com/exercise/VowelCounter.java#L10)

Suggestion: We could add the condition args != null to avoid a NullPointerException, and we could create a static constant variable for the number 4 to improve readability

[System.out.println("Extra arguments passed.");](https://github.com/LeonardoScalabrini/qaengineer-technical-challenge/blob/22619419459a370d6bd01e63009d1420fda93221/src/main/java/com/exercise/VowelCounter.java#L11)

Suggestion: Instead of printing a message, we could throw an exception with the message "Extra arguments passed"

[return null](https://github.com/LeonardoScalabrini/qaengineer-technical-challenge/blob/22619419459a370d6bd01e63009d1420fda93221/src/main/java/com/exercise/VowelCounter.java#L12)

Suggestion: If we throw an exception we can ignore this suggestion, but, avoiding returning null we could return a empty list, Ex:
```java
return List.of()
```

[} else {](https://github.com/LeonardoScalabrini/qaengineer-technical-challenge/blob/22619419459a370d6bd01e63009d1420fda93221/src/main/java/com/exercise/VowelCounter.java#L13)

Suggestion: This else condition is unnecessary and can be removed, Ex:
```java
if (args.length >= 4) {
        System.out.println("Extra arguments passed.");
        return null;
    }
    List<String> argumentList = Arrays.asList(args);
    List<CountResult> vowelCount = new ArrayList<>();
    argumentList.forEach(argument -> vowelCount.add(new CountResult(argument, getVowelCount(argument))));
    return vowelCount;
```

[List<String> argumentList = Arrays.asList(args);](https://github.com/LeonardoScalabrini/qaengineer-technical-challenge/blob/22619419459a370d6bd01e63009d1420fda93221/src/main/java/com/exercise/VowelCounter.java#L14)

Suggestion: This block of code could be refactored to use a functional style, improving readability
```java
return Arrays.stream(args)
                .map(word -> new CountResult(word, getVowelCount(word)))
                .collect(Collectors.toList());
```

[private Integer getVowelCount(String input)](https://github.com/LeonardoScalabrini/qaengineer-technical-challenge/blob/22619419459a370d6bd01e63009d1420fda93221/src/main/java/com/exercise/VowelCounter.java#L21)

Suggestion: This block of code also could be refactored to use a functional style and improving readability
```java
return (int) input.chars()
                .filter(c -> "aeiou".indexOf(c) >= 0)
                .count();
```

["aeiou"](https://github.com/LeonardoScalabrini/qaengineer-technical-challenge/blob/22619419459a370d6bd01e63009d1420fda93221/src/main/java/com/exercise/VowelCounter.java#L23)

Suggestion: We also could create a static constant variable for the string "aeiou" to improve readability

## Main

[System.out.println(result);](https://github.com/LeonardoScalabrini/qaengineer-technical-challenge/blob/22619419459a370d6bd01e63009d1420fda93221/src/main/java/com/exercise/Main.java#L8)

Suggestion: How result is a list, we could refactor to the code below to improve the result prints
```java
result.forEach(System.out::println);
```
