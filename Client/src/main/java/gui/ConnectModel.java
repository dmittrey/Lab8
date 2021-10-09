package gui;

import utility.CommandManager;
import utility.RequestHandler;
import utility.TypeOfAnswer;
import utility.Validator;

import javax.swing.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
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

    public void setPanel(JFrame jFrame) {
        jFrame.setTitle("Connecting");
        jFrame.setContentPane(mainPanel);
        jFrame.pack();
    }

    public void setWarn(TypeOfAnswer typeOfAnswer) {
        warnField.setText(typeOfAnswer.toString());
    }
}
