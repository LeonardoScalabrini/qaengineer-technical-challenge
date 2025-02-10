package com.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCounter {

    public List<CountResult> getCountResult(String[] args) throws Exception {
        if (args.length > 4) {
            throw new Exception("Extra arguments passed.");
        }
        List<String> argumentList = Arrays.asList(args);
        List<CountResult> vowelCount = new ArrayList<>();
        argumentList.forEach(argument -> vowelCount.add(new CountResult(argument, getVowelCount(argument), getConsonantCount(argument))));
        return vowelCount;
    }

    private Integer getVowelCount(String input) {
        String[] inputChars = input.toLowerCase().split("");
        return (int) Arrays.stream(inputChars).filter(inputChar -> inputChar.matches("[aeiou]")).count();
    }

    private Integer getConsonantCount(String input) {
        String[] inputChars = input.toLowerCase().split("");
        return (int) Arrays.stream(inputChars).filter(inputChar -> inputChar.matches("[bcdfghjklmnpqrstvwxyz]")).count();
    }
}
