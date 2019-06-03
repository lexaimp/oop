package ru.academIT.babushkin.Model;

public class Celsius implements Temperature {
    private static final String name = "Celsius";
    private double temperature = 0;

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double toCelsius() {
        return temperature;
    }

    @Override
    public double fromCelsius() {
        return temperature;
    }
}