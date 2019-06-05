package ru.academIT.babushkin.Controller;

import ru.academIT.babushkin.Model.Temperature;

public class TemperatureController {
    private Temperature[] temperatureUnits;

    public TemperatureController(Temperature[] temperatureUnits) {
        this.temperatureUnits = temperatureUnits;
    }

    public double convert(String from, String to, double value) {
        Temperature unitFrom = findUnit(from);
        Temperature unitTo = findUnit(to);
        if (unitFrom == null || unitTo == null) {
            return 0;
        }
        return unitTo.fromCelsius(unitFrom.toCelsius(value));
    }

    private Temperature findUnit(String unit) {
        for (Temperature u : temperatureUnits) {
            if (u.toString().equals(unit)) {
                return u;
            }
        }
        return null;
    }

    public String[] toArray() {
        String[] namesArray = new String[temperatureUnits.length];
        for (int i = 0; i < namesArray.length; i++) {
            namesArray[i] = temperatureUnits[i].toString();
        }
        return namesArray;
    }
}