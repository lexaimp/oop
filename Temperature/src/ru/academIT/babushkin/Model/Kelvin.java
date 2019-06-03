package ru.academIT.babushkin.Model;

public class Kelvin implements Temperature {
    private static final String name = "Kelvin";
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
        return temperature - 273.15;
    }

    @Override
    public double fromCelsius() {
        return temperature + 273.15;
    }
}
