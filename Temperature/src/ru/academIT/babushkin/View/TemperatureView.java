package ru.academIT.babushkin.View;

import javax.swing.*;

import static javax.swing.GroupLayout.Alignment.LEADING;

public class TemperatureView extends JFrame {

    public TemperatureView(String title) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(title);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(new JLabel("Temperature")).addGroup(layout.createParallelGroup(LEADING)));

    }

    private JLabel label() {
        JLabel label = new JLabel("Temperature");
        return label;
    }
}