package ru.academIT.babushkin.Model;

public class Fahrenheit implements Temperature {
    private static final String name = "Fahrenheit";

    @Override
    public double toCelsius(double inputValue) {
        return (inputValue - 32) * ((double) 5 / 9);
    }

    @Override
    public double fromCelsius(double outputValue) {
        return outputValue * ((double) 9 / 5) + 32;
    }

    @Override
    public String toString() {
        return name;
    }
}
