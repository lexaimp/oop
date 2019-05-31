package ru.academIT.babushkin.View;

import javax.swing.*;

import java.awt.*;

public class TemperatureView extends JFrame {
    private String[] temperatureUnits; // Массив для хранения наименования едениц измерения

    private JLabel errorLabel = error();

    public TemperatureView(String title) {
        setTitle(title);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        int width = 500;
        int height = 180;
        setSize(width, height);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(screenSize.width / 2 - width / 2, screenSize.height / 2 - height / 2);
        add(panel(), BorderLayout.LINE_START);
        add(errorLabel, BorderLayout.NORTH);
        add(panelWithButton(), BorderLayout.CENTER);
        add(panel(), BorderLayout.LINE_END);
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
        field.addActionListener(e -> {
            try {
                Integer.parseInt(field.getText());
                errorLabel.setVisible(false);
            } catch (NumberFormatException exception) {
                errorLabel.setText("Введите целое число");
                errorLabel.setVisible(true);
            }
        });
        return field;
    }

    private JPanel panel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(textFieldForGetInteger(), getGridBagConstraints());
        String[] items = {
                "Элемент списка 1",
                "Элемент списка 2",
                "Элемент списка 3"
        };
        panel.add(new JComboBox(items), getGridBagConstraints());
        return panel;
    }

    private JPanel panelWithButton() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.add(new JButton("Перевести"), getGridBagConstraints());
        return panel;
    }

    private JTextField textField() {
        JTextField textField = new JTextField();
        return textField;
    }

    private JLabel error(String ErrorText, boolean visible) {
        JLabel label = new JLabel(ErrorText);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font(label.getName(), Font.PLAIN, 15));
        label.setForeground(Color.RED);
        label.setVisible(visible);
        return label;
    }

    private JLabel error() {
        JLabel label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setFont(new Font(label.getName(), Font.PLAIN, 15));
        label.setForeground(Color.RED);
        label.setVisible(false);
        return label;
    }
}