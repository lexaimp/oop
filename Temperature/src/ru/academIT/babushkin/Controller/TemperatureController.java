package ru.academIT.babushkin.Controller;

import ru.academIT.babushkin.Model.Celsius;

import java.util.ArrayList;

public class TemperatureController {
    private String[] temperatureUnits = {new Celsius(), };

    public ArrayList getTemperatureUnits() {
        return temperatureUnits;
    }

    public void addUnit(Object unit) {
        temperatureUnits.add(unit);
    }

    public void setUnits(String temperatureUnit) {

    }
}