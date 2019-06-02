package ru.academIT.babushkin.View;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;

public class TemperatureView extends JFrame {
    private String[] temperatureUnits; // Массив для хранения наименования едениц измерения

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

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weightx = 1;
        constraints.insets = new Insets(1, 10, 5, 10);
        constraints.gridwidth = GridBagConstraints.REMAINDER;

        JTextField textFieldForGetDouble = new JTextField();

        JLabel errorLabel = new JLabel();
        errorLabel.setFont(new Font(errorLabel.getName(), Font.PLAIN, 15));
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        JButton button = new JButton("Перевести");

        textFieldForGetDouble.getDocument().addDocumentListener(new DocumentListener() {
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
                    Double.parseDouble(textFieldForGetDouble.getText());
                    errorLabel.setVisible(false);
                    button.setEnabled(true);
                } catch (NumberFormatException exception) {
                    errorLabel.setText("Введите числовое значение");
                    errorLabel.setVisible(true);
                    button.setEnabled(false);

                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridBagLayout());
        inputPanel.add(textFieldForGetDouble, constraints);
        inputPanel.add(new JComboBox<>(temperatureUnits), constraints);

        JPanel centralPanel = new JPanel();
        centralPanel.setLayout(new GridLayout(2, 1));
        JPanel panelWithErrorLabel = new JPanel();
        panelWithErrorLabel.setLayout(new GridBagLayout());
        panelWithErrorLabel.add(errorLabel, constraints);
        centralPanel.add(panelWithErrorLabel);
        centralPanel.add(new JPanel().add(button));

        add(inputPanel);
        add(centralPanel);
        add(new JPanel());
    }
}