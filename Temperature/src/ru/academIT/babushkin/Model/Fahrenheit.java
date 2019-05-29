package ru.academIT.babushkin.Model;

public class Fahrenheit implements Temperature {
    private static final Unit name = Unit.FAHRENHEIT;
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
        return (temperature - 32) * ((double) 5 / 9);
    }

    @Override
    public double fromCelsius() {
        return temperature * ((double) 9 / 5) + 32;
    }
}