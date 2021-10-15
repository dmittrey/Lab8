package gui;

import utility.TypeOfAnswer;

import javax.swing.*;
import java.util.Arrays;

public class RegisterModel extends JFrame {
    private JPanel mainPanel;
    private JButton loginButton;
    private JButton submitButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPasswordField passwordField2;
    private JTextField warnField;

    public RegisterModel() {
        loginButton.addActionListener(e -> FrameHandler.getInstance().setAuth());
        submitButton.addActionListener(e -> {
            if (Arrays.equals(passwordField.getPassword(), passwordField2.getPassword())) {
                FrameHandler.getInstance().register(usernameField.getText(), passwordField.getPassword());
            } else setWarn(TypeOfAnswer.NOTMATCH);
        });
    }

    public void setPanel(MainFrame jFrame) {
        jFrame.setTitle("Register");
        jFrame.setSize(400,300);
        jFrame.setLocation();
        jFrame.setContentPane(mainPanel);
        jFrame.revalidate();
    }

    public void setWarn(TypeOfAnswer typeOfAnswer) {
        warnField.setText(typeOfAnswer.toString());
    }
}