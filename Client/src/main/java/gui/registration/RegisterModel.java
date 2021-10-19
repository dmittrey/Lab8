package gui.registration;

import javax.swing.*;

public class RegisterModel extends JFrame {
    private JPanel mainPanel;
    private JButton loginButton;
    private JButton submitButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField passwordField2;
    private JTextField warnField;

    public RegisterModel(RegisterController registerController) {
        loginButton.addActionListener(e -> registerController.switchLogin());
        submitButton.addActionListener(e -> registerController.register());
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public char[] getFirstPassword() {
        return passwordField.getPassword();
    }

    public char[] getSecondPassword() {
        return passwordField2.getPassword();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public JTextField getWarnField() {
        return warnField;
    }
}