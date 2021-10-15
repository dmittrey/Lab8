package gui;

import utility.TypeOfAnswer;

import javax.swing.*;

public class LoginModel {
    private JPanel mainPanel;
    private JButton registerButton;
    private JPasswordField passwordField;
    private JButton submitButton;
    private JTextField usernameField;
    private JTextField warnField;

    public LoginModel() {
        registerButton.addActionListener(e -> FrameHandler.getInstance().setRegister());
        submitButton.addActionListener(e -> FrameHandler.getInstance().login(usernameField.getText(), passwordField.getPassword()));
    }

    public void setPanel(MainFrame jFrame) {
        jFrame.setTitle("Login");
        jFrame.setSize(400, 200);
        jFrame.setLocation();
        jFrame.setContentPane(mainPanel);
        jFrame.revalidate();
    }

    public void setWarn(TypeOfAnswer typeOfAnswer) {
        warnField.setText(typeOfAnswer.toString());
    }
}