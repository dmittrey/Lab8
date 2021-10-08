package gui;

import javax.swing.*;

public class Auth {
    private JPanel rootPanel;
    private JButton registerButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton submitButton;

    public Auth() {
        submitButton.addActionListener(e -> receiver.registerUser());
    }

    private void createUIComponents() {

    }
}
