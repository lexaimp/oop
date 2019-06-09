package ru.academIT.babushkin.Model;

public class Kelvin implements Temperature {
    private static final String name = "Кельвин";

    @Override
    public double toCelsius(double inputValue) {
        return inputValue - 273.15;
    }

    @Override
    public double fromCelsius(double outputValue) {
        return outputValue + 273.15;
    }

    @Override
    public String toString() {
        return name;
    }
}