import javax.swing.*;

public class HelloWorld extends JFrame {
    public HelloWorld() {
        super("Test");
        this.setSize(300, 200);
        this.getContentPane().setLayout(null);
        this.add(getJLabel());
        this.add(getComboBox());
        this.add(getTextField());
    }

    private JLabel getJLabel() {
        JLabel jLabel = new JLabel();
        jLabel.setBounds(34, 49, 53, 18);
        jLabel.setText("Name:");
        return jLabel;

    }

    private JComboBox getComboBox() {
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(34, 69, 83, 20);
        comboBox.addItem("Hi");
        comboBox.addItem("Friend");
        return comboBox;
    }

    private JTextField getTextField() {
        JTextField textField = new JTextField();
        textField.setBounds(34, 89, 83, 20);
        textField.setText("111");
        return textField;
    }
}
