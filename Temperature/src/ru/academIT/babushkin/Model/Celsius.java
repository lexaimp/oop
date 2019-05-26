package ru.academIT.babushkin.Model;

public class Celsius implements Temperature {
    private static final Unit name = Unit.CELSIUS;
    private double temperature = 0;

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    @Override
    public Unit getName() {
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