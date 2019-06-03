package ru.academIT.babushkin.Model;

public interface Temperature {
    String getName();

    double toCelsius(double inputValue);

    double fromCelsius(double outputValue);
}