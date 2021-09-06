package com.epam.task5002;

public class NumbersGeneratorUtil {
    private static int number = 100000000;

    public static int nextNumber() {
        number++;
        return number;
    }
}
