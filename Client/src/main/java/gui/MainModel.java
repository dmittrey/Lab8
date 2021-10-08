package gui;

import javax.swing.*;

public class MainModel extends JFrame {
    private JTextField usernameTextField;
    private JPanel mainPanel;
    private JPanel commandPanel;
    private JComboBox comboBox1;
    private JPanel argumentPanel;
    private JTextField textField1;
    private JButton submitButton;
    private JTable stGroupsTable;
    private JButton visualButton;
    private JPanel clientInfo;
    private JPanel serverInfo;
    private JTextField textField2;
    private JTextField textField3;

    public MainModel() {
        setTitle("Collection table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
    }
}