package gui.logining;

import gui.LangChangeMenu;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginModel {
    private JPanel mainPanel;
    private JButton registerButton;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JTextField usernameField;
    private JTextField warnField;
    private JLabel usernameText;
    private JLabel passwordText;
    private JButton langButton;
    private ResourceBundle loginBundle;
    private final LoginController loginController;

    public LoginModel(LoginController aLoginController) {
        loginController = aLoginController;
        registerButton.addActionListener(e -> loginController.switchRegister());
        submitButton.addActionListener(e -> loginController.login());
        langButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    new LangChangeMenu(loginController).show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        switchLanguage(new Locale("en", "AU"));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public String getUsername() {
        return usernameField.getText().trim();
    }

    public char[] getPassword() {
        return passwordField.getPassword();
    }

    public JTextField getWarnField() {
        return warnField;
    }

    public void switchLanguage(Locale locale) {
        loginBundle = ResourceBundle.getBundle("gui.bundles.LoginLabels", locale);
        fillLabels();
    }

    private void fillLabels() {
        langButton.setText(loginBundle.getString("language"));
        registerButton.setText(loginBundle.getString("register"));
        usernameText.setText(loginBundle.getString("username"));
        passwordText.setText(loginBundle.getString("password"));
        submitButton.setText(loginBundle.getString("submit"));
    }
}