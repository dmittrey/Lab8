package gui.logining;

import javax.swing.*;

public class LoginModel {
    private JPanel mainPanel;
    private JButton registerButton;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JTextField usernameField;
    private JTextField warnField;

    public LoginModel(LoginController loginController) {
        registerButton.addActionListener(e -> loginController.switchRegister());
        submitButton.addActionListener(e -> loginController.login());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public String getUsername() {
        return usernameField.getText();
    }

    public char[] getPassword() {
        return passwordField.getPassword();
    }

    public JTextField getWarnField() {
        return warnField;
    }
}