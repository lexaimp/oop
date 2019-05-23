import javax.swing.*;

public class HelloWorld extends JFrame {
    public HelloWorld() {
        super();
        this.setSize(300, 200);
        this.getContentPane().setLayout(null);
        this.setTitle("HelloWorld");
        this.add(getJLabel());
        this.add(getComboBox());
    }

    private JLabel getJLabel() {
        JLabel jLabel = new JLabel();
        jLabel.setBounds(34, 49, 53, 18);
        jLabel.setText("Name:");
        return jLabel;

    }private JComboBox getComboBox() {
        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(34, 69, 83, 20);
        comboBox.addItem("Hi");
        comboBox.addItem("Friend");
        return comboBox;
    }
}
