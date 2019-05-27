package ru.academIT.babushkin.View;

import javax.swing.*;

public class TemperatureView extends JFrame {

    public TemperatureView(int width, int height, String title) {
        this.setSize(width, height);
        this.setTitle(title);
        this.setLayout(new GroupLayout(this));
    }

    private GroupLayout getGroupLayout() {
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(label());
        return groupLayout;
    }

    private JLabel label() {
        JLabel label = new JLabel("Temperature");
        return label;
    }
}