package gui;

import javax.swing.*;

public class RegisterModel extends JFrame {
    private JPanel mainPanel;
    private JButton loginButton;
    private JPasswordField passwordField2;

    public RegisterModel() {
        loginButton.addActionListener(e -> FrameHandler.getInstance().swapAuth());
        setTitle("Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
    }
}
