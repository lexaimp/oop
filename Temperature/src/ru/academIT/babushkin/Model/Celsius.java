package ru.academIT.babushkin.Model;

public class Celsius implements Temperature {
    private static final String name = "Celsius";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double toCelsius(double inputValue) {
        return inputValue;
    }

    @Override
    public double fromCelsius(double outputValue) {
        return outputValue;
    }
}