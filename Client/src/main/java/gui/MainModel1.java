package gui;

import javax.swing.*;

public class MainModel1 extends JFrame {
    private JPanel mainPanel;
    private JTextField usernameField;
    private JPanel commandPanel;
    private JComboBox commandBox;
    private JPanel argumentPanel;
    private JTextField argumentField;
    private JButton submitButton;
    private JTable stGroupTable;
    private JButton visualButton;
    private JPanel client;
    private JTextField clientInfo;
    private JPanel server;
    private JTextField serverInfo;

    public MainModel1() {
    }

    public void setPanel(JFrame jFrame) {
        jFrame.setTitle("Register");
        jFrame.setContentPane(mainPanel);
        jFrame.pack();
    }
}
