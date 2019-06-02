package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.View.TemperatureView;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        String[] string = {"c", "f", "k"};
        SwingUtilities.invokeLater(() -> new TemperatureView("Temperature converter", string).setVisible(true));
    }
}