package gui.connection;

import javax.swing.*;

public class ConnectModel {

    private JPanel mainPanel;
    private JPanel remoteHostAddress;
    private JTextField hostAddress;
    private JPanel remoteHostPort;
    private JTextField hostPort;
    private JButton button1;
    private JTextField warnField;

    public ConnectModel(ConnectController connectController) {
        button1.addActionListener(e -> connectController.connect());
    }

    public String getAddress() {
        return hostAddress.getText();
    }

    public String getPort() {
        return hostPort.getText();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setWarn(String aWarnText) {
        warnField.setText(aWarnText);
    }
}