package ru.aston.khmarenko_gi.task2;

public class TooYoungCustomer extends Exception{
    private final static int number = 2049;
    private final String message;

    public int getNumber() {
        return number;
    }

    public TooYoungCustomer(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Exception: " + "TooYoungCustomer, number: "
                + getNumber() + ", message: " + message;
    }
}
