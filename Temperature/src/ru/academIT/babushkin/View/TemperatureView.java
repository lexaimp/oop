package ru.academIT.babushkin.View;

import javax.swing.*;

import java.awt.*;

public class TemperatureView extends JFrame {

    public TemperatureView(String title) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(400, 100);
        add(panel(), BorderLayout.LINE_START);
        add(label(), BorderLayout.CENTER);
        add(panel(), BorderLayout.LINE_END);
        add(panel(), BorderLayout.PAGE_END);
    }

    private GridBagConstraints getGridBagConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        return constraints;
    }

    private JPanel panel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(new JTextField(), getGridBagConstraints());
        String[] items = {
                "Элемент списка 1",
                "Элемент списка 2",
                "Элемент списка 3"
        };
        panel.add(new JComboBox(items), getGridBagConstraints());
        return panel;
    }

    private JLabel label() {
        JLabel label = new JLabel("=");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Font", Font.PLAIN, 40));
        return label;
    }

    private JTextField textField() {
        JTextField textField = new JTextField();
        return textField;
    }
}