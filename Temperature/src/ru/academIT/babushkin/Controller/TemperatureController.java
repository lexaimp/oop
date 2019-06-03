package ru.academIT.babushkin.Controller;

import ru.academIT.babushkin.Model.Celsius;
import ru.academIT.babushkin.Model.Fahrenheit;
import ru.academIT.babushkin.Model.Kelvin;
import ru.academIT.babushkin.Model.Temperature;

public class TemperatureController {
    private Temperature[] temperatureUnits = {new Celsius(), new Fahrenheit(), new Kelvin()};

    public double convert(double value, String from, String to) {
        return findUnit(from).toCelsius(findUnit(to).fromCelsius(value));
    }

    private Temperature findUnit(String unit) {
        for (Temperature u : temperatureUnits) {
            if (u.getName().equals(unit)) {
                return u;
            }
        }
        return null;
    }

    public String[] toArray() {
        String[] namesArray = new String[temperatureUnits.length];
        for (int i = 0; i < namesArray.length; i++) {
            namesArray[i] = temperatureUnits[i].getName();
        }
        return namesArray;
    }
}