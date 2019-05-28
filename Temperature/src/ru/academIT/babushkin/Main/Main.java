package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.View.TemperatureView;


public class Main {
    public static void main(String[] args) {
        TemperatureView view = new TemperatureView("Temperature");
        view.setVisible(true);
    }
}
