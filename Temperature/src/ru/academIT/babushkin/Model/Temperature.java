package ru.academIT.babushkin.Model;

public interface Temperature {
    double toCelsius(double inputValue);

    double fromCelsius(double outputValue);

    String toString();
}