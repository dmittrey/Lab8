package gui.connection;

import gui.LangChangeMenu;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;

public class ConnectModel {

    private JPanel mainPanel;
    private JPanel remoteHostAddress;
    private JTextField hostAddress;
    private JPanel remoteHostPort;
    private JTextField hostPort;
    private JButton connectButton;
    private JTextField warnField;
    private JButton langButton;
    private ResourceBundle connectBundle;

    public ConnectModel(ConnectController connectController) {
        connectButton.addActionListener(e -> connectController.connect());
        langButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    new LangChangeMenu(connectController).show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        switchLanguage(new Locale("en", "AU"));
    }

    public String getAddress() {
        return hostAddress.getText().trim();
    }

    public String getPort() {
        return hostPort.getText().trim();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setWarn(String aWarnText) {
        warnField.setText(aWarnText);
    }

    public void switchLanguage(Locale locale) {
        connectBundle = ResourceBundle.getBundle("gui.bundles.ConnectLabels", locale);
        fillLabels();
    }

    private void fillLabels() {
        langButton.setText(connectBundle.getString("language"));
        String remoteHostAddressTitle = connectBundle.getString("remoteHostAddress");
        String remoteHostPortTitle = connectBundle.getString("remoteHostPort");
        connectButton.setText(connectBundle.getString("connect"));

        LineBorder roundedLineBorder = new LineBorder(Color.black, 1, true);
        TitledBorder addressTitledBorder = new TitledBorder(roundedLineBorder, remoteHostAddressTitle);
        TitledBorder portTitledBorder = new TitledBorder(roundedLineBorder, remoteHostPortTitle);
        remoteHostAddress.setBorder(addressTitledBorder);
        remoteHostPort.setBorder(portTitledBorder);
    }
}