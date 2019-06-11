package ru.academIT.babushkin.View;

import ru.academIT.babushkin.Controller.TemperatureController;
import ru.academIT.babushkin.Model.Temperature;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.*;

public class TemperatureView {
    public TemperatureView(Temperature[] temperatureUnits) {
        TemperatureController temperatureController = new TemperatureController(temperatureUnits);
        SwingUtilities.invokeLater(() -> {
            JFrame mainFrame = new JFrame();
            mainFrame.setTitle("Перевод температур");
            mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            int width = 700;
            int height = 150;
            mainFrame.setMinimumSize(new Dimension(width, height));
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            mainFrame.setLocation(screenSize.width / 2 - width / 2, screenSize.height / 2 - height / 2);
            mainFrame.setLayout(new GridLayout(1, 3));

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
            inputPanel.add(new JLabel("Исходная величина"), constraints);
            inputPanel.add(textFieldForGetDouble, constraints);
            JComboBox fromBox = new JComboBox<>(temperatureController.toArray());
            inputPanel.add(fromBox, constraints);

            JPanel centralPanel = new JPanel();
            centralPanel.setLayout(new GridLayout(2, 1));

            JPanel panelWithErrorLabel = new JPanel();
            panelWithErrorLabel.add(errorLabel);
            centralPanel.add(panelWithErrorLabel);

            JPanel panelWithButton = new JPanel();
            panelWithButton.add(button);
            centralPanel.add(panelWithButton);

            JTextField textFieldForPrintOutput = new JTextField();
            textFieldForPrintOutput.setEditable(false);

            JPanel outputPanel = new JPanel();
            outputPanel.setLayout(new GridBagLayout());
            outputPanel.add(new JLabel("Преобразованная величина"), constraints);
            outputPanel.add(textFieldForPrintOutput, constraints);
            JComboBox toBox = new JComboBox<>(temperatureController.toArray());
            outputPanel.add(toBox, constraints);

            mainFrame.add(inputPanel);
            mainFrame.add(centralPanel);
            mainFrame.add(outputPanel);
            button.addActionListener(e -> {
                try {
                    double result = temperatureController.convert((String) fromBox.getSelectedItem(), (String) toBox.getSelectedItem(), Double.parseDouble(textFieldForGetDouble.getText()));
                    textFieldForPrintOutput.setText(String.valueOf(result));
                } catch (NumberFormatException exception) {
                    errorLabel.setText("<html>Введите значение в поле ввода<br> исходной величины</html>");
                    errorLabel.setVisible(true);
                }
            });
            mainFrame.setVisible(true);
        });
    }
}