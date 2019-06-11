package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.Model.Celsius;
import ru.academIT.babushkin.Model.Fahrenheit;
import ru.academIT.babushkin.Model.Kelvin;
import ru.academIT.babushkin.Model.Temperature;
import ru.academIT.babushkin.View.TemperatureView;

public class Main {
    public static void main(String[] args) {
        Temperature[] temperatureUnits = {new Celsius(), new Fahrenheit(), new Kelvin()};
        new TemperatureView(temperatureUnits);
    }
}