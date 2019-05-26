package ru.academIT.babushkin.Model;

public interface Temperature {
    public Unit getName();

    public double toCelsius();

    public double fromCelsius();
}