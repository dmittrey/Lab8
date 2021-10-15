package gui;

import utility.CommandManager;
import utility.TypeOfAnswer;

import javax.swing.*;
import java.util.logging.Logger;

public class ConnectModel {

    private static final Logger logger = Logger.getLogger(CommandManager.class.getName());

    private JPanel mainPanel;
    private JPanel remoteHostAddress;
    private JTextField textField1;
    private JPanel remoteHostPort;
    private JTextField textField2;
    private JButton button1;
    private JTextField warnField;

    public ConnectModel() {
        button1.addActionListener(e -> {
            String hostAddress = textField1.getText();
            String hostPort = textField2.getText();
            logger.info(hostAddress);
            logger.info(hostPort);

            FrameHandler.getInstance().connect(hostAddress, hostPort);
        });
    }

    public void setPanel(MainFrame jFrame) {
        jFrame.setTitle("Connecting");
        jFrame.setSize(400,200);
        jFrame.setLocation();
        jFrame.setContentPane(mainPanel);
        jFrame.revalidate();
    }

    public void setWarn(TypeOfAnswer typeOfAnswer) {
        warnField.setText(typeOfAnswer.toString());
    }
}
// FIXME: 15.10.2021 Добавить hotkey на Enter на вход
