package ru.academIT.babushkin.View;

import javax.swing.*;

import java.awt.*;

public class TemperatureView extends JFrame {

    public TemperatureView(String title) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle(title);
        setSize(500, 400);
        setResizable(false);
        setLayout(new GridLayout());
        add(panel());
        add(label());
        add(new JButton());

    }

    private JLabel label() {
        JLabel label = new JLabel("=");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Size", Font.PLAIN, 40));
        return label;
    }

    private JPanel panel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(textField());
        panel.add(new JButton("2"));
        return panel;
    }

    private JPanel panel1() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JLabel("="), BorderLayout.CENTER);
        panel.add(new JTextArea("="), BorderLayout.NORTH);
        return panel;
    }

    private JTextField textField() {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 2));
        return textField;
    }
}