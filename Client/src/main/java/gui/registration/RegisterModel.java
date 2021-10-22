package gui.registration;

import gui.LangChangeMenu;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

public class RegisterModel extends JFrame {
    private JPanel mainPanel;
    private JButton loginButton;
    private JButton submitButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField passwordField2;
    private JTextField warnField;
    private JButton langButton;
    private JLabel usernameText;
    private JLabel firstPasswordText;
    private JLabel secondPasswordText;
    private ResourceBundle registerBundle;

    public RegisterModel(RegisterController registerController) {
        loginButton.addActionListener(e -> registerController.switchLogin());
        submitButton.addActionListener(e -> registerController.register());
        langButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    new LangChangeMenu(registerController).show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        switchLanguage(new Locale("en", "AU"));
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

    public void switchLanguage(Locale locale) {
        registerBundle = ResourceBundle.getBundle("gui.bundles.RegisterLabels", locale);
        fillLabels();
    }

    private void fillLabels() {
        loginButton.setText(registerBundle.getString("login"));
        langButton.setText(registerBundle.getString("language"));
        usernameText.setText(registerBundle.getString("username"));
        firstPasswordText.setText(registerBundle.getString("password"));
        secondPasswordText.setText(registerBundle.getString("passwordAgain"));
        submitButton.setText(registerBundle.getString("submit"));
    }
}