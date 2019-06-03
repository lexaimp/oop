package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.Controller.TemperatureController;
import ru.academIT.babushkin.View.TemperatureView;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        TemperatureController temperatureController = new TemperatureController();
        SwingUtilities.invokeLater(() -> new TemperatureView("Temperature converter", (String[]) temperatureController.getTemperatureUnits().toArray()).setVisible(true));
    }
}