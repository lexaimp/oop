package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.Controller.TemperatureController;
import ru.academIT.babushkin.Model.Celsius;
import ru.academIT.babushkin.Model.Fahrenheit;
import ru.academIT.babushkin.Model.Kelvin;
import ru.academIT.babushkin.Model.Temperature;
import ru.academIT.babushkin.View.TemperatureView;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        Temperature[] temperatures = {new Celsius(), new Fahrenheit(), new Kelvin()};
        SwingUtilities.invokeLater(() -> new TemperatureView("Temperature converter", new TemperatureController(temperatures)).setVisible(true));
    }
}