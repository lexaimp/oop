package ru.academIT.babushkin.View;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;

public class TemperatureView extends JFrame {
    private String[] temperatureUnits; // Массив для хранения наименования едениц измерения

    private JLabel errorLabel = error();
    private JButton button = new JButton("Перевести");

    public TemperatureView(String title, String[] temperatureUnits) {
        this.temperatureUnits = temperatureUnits;
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        int width = 500;
        int height = 180;
        setSize(width, height);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width / 2 - width / 2, screenSize.height / 2 - height / 2);
        setLayout(new GridLayout(1, 3));

        add(panel());
        add(centralPanel());
        add(panel());
    }

    private GridBagConstraints getGridBagConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.insets = new Insets(1, 10, 5, 10);
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        return constraints;
    }

    private JTextField textFieldForGetInteger() {
        JTextField field = new JTextField();
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                IntegerInspection();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                IntegerInspection();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                IntegerInspection();
            }

            private void IntegerInspection() {
                try {
                    Double.parseDouble(field.getText());
                    errorLabel.setVisible(false);
                    button.setEnabled(true);
                } catch (NumberFormatException exception) {
                    errorLabel.setText("Введите число");
                    errorLabel.setVisible(true);
                    button.setEnabled(false);

                }
            }
        });
        return field;
    }

    private JPanel panel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(textFieldForGetInteger(), getGridBagConstraints());
        panel.add(new JComboBox<>(temperatureUnits), getGridBagConstraints());
        return panel;
    }

    private JPanel centralPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2, 1));
        JPanel panelWithErrorLabel = new JPanel();
        panelWithErrorLabel.setLayout(new GridBagLayout());
        panelWithErrorLabel.add(errorLabel, getGridBagConstraints());
        panel.add(panelWithErrorLabel);
        panel.add(new JPanel().add(button));
        return panel;
    }

    private JLabel error() {
        JLabel label = new JLabel();
        label.setFont(new Font(label.getName(), Font.PLAIN, 15));
        label.setForeground(Color.RED);
        label.setVisible(false);
        return label;
    }
}