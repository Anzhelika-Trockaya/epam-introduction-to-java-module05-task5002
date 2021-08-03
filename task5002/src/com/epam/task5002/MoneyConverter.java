package com.epam.task5002;

public class MoneyConverter {
    public static long getKopecks(double rubles) {
        return (long) (rubles * 100);
    }

    public static double getRubles(long kopecks) {
        String value = Long.toString(kopecks);
        if (value.length() < 3) value = String.format("%03d",kopecks);
        value = value.substring(0, value.length() - 2) + "." + value.substring(value.length() - 2);
        return Double.parseDouble(value);
    }
}
