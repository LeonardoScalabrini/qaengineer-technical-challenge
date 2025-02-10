package com.exercise;

public class CountResult {
    private final String word;
    private final Integer vowelCount;
    private final Integer consonantCount;

    public CountResult(String word, Integer vowelCount, Integer consonantCount) {
        this.word = word;
        this.vowelCount = vowelCount;
        this.consonantCount = consonantCount;
    }

    public String getWord() {
        return word;
    }

    public Integer getVowelCount() {
        return vowelCount;
    }

    public Integer getConsonantCount() {
        return consonantCount;
    }

    @Override
    public String toString() {
        return "CountResult{" +
                "word='" + word + '\'' +
                ", vowelCount=" + vowelCount +
                ", consonantCount=" + consonantCount +
                '}';
    }
}
