package gui;

import javax.swing.*;

public class LoginModel extends JFrame {
    private JPanel mainPanel;
    private JButton registerButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton submitButton;

    public LoginModel() {
        registerButton.addActionListener(e -> FrameHandler.getInstance().swapAuth());
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
    }
}