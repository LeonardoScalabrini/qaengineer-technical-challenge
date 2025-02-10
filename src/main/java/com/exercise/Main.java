package com.exercise;

public class Main {

    public static void main(String[] args) throws Exception {
        StringCounter counter = new StringCounter();
        var result = counter.getCountResult(args);
        System.out.println(result);
    }
}
