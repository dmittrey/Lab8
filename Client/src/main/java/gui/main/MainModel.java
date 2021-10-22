package gui.main;

import gui.*;
import utility.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class MainModel {
    private JPanel mainPanel;
    private JTextField usernameField;
    private JPanel commandPanel;
    private JComboBox<String> commandBox;
    private JPanel argumentPanel;
    private JTextField argumentField;
    private JButton submitButton;
    private JButton visualButton;
    private JPanel client;
    private JTextField clientInfo;
    private JTextField serverInfo;
    private JPanel server;
    private JScrollPane sgScrollPane;
    private JTable jTable;
    private JButton langButton;
    private ResourceBundle mainBundle;
    private static final Logger logger = Logger.getLogger(MainModel.class.getName());

    public MainModel(MainController mainController, FrameHandler aFrameHandler) {
        submitButton.addActionListener(e -> mainController.executeCommand());
        jTable.setModel(SGTableModel.getInstance());
        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 3) {
                    int rowAtPoint = jTable.rowAtPoint(e.getPoint());
                    int columnAtPoint = jTable.columnAtPoint(e.getPoint());
                    if (rowAtPoint != -1 && columnAtPoint != -1) {
                        String sgId = (String) jTable.getValueAt(rowAtPoint, 0);
                        logger.info("Mouse selected study group №" + sgId);
                        new SGChangeMenu(aFrameHandler, sgId, rowAtPoint, columnAtPoint)
                                .show(e.getComponent(), e.getX(), e.getY());
                    }
                }
            }
        });
        langButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == 1) {
                    new LangChangeMenu(mainController).show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });
        switchLanguage(new Locale("en", "AU"));
    }

    public TypeOfCommand getTypeOfCommand() {
        return TypeOfCommand.getEnum(commandBox.getItemAt(commandBox.getSelectedIndex()));
    }

    public String getArgument() {
        return argumentField.getText();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void setUsername(String username) {
        usernameField.setText(username);
    }

    public JTextField getClientInfo() {
        return clientInfo;
    }

    public JTextField getServerInfo() {
        return serverInfo;
    }

    public void switchLanguage(Locale locale) {
        mainBundle = ResourceBundle.getBundle("gui.bundles.MainLabels", locale);
        fillLabels();
    }

    private void fillLabels() {
        langButton.setText(mainBundle.getString("language"));
        visualButton.setText(mainBundle.getString("visualMode"));
        String commandTitle = mainBundle.getString("command");
        String argumentTitle = mainBundle.getString("argument");
        submitButton.setText(mainBundle.getString("submit"));
        String clientTitle = mainBundle.getString("clientInfo");
        String serverTitle = mainBundle.getString("serverInfo");
        String sgTableTitle = mainBundle.getString("studyGroupTable");

        LineBorder roundedLineBorder = new LineBorder(Color.black, 1, true);
        TitledBorder commandTitledBorder = new TitledBorder(roundedLineBorder, commandTitle);
        TitledBorder argumentTitledBorder = new TitledBorder(roundedLineBorder, argumentTitle);
        TitledBorder clientTitledBorder = new TitledBorder(roundedLineBorder, clientTitle);
        TitledBorder serverTitledBorder = new TitledBorder(roundedLineBorder, serverTitle);
        TitledBorder sgTableTitledBorder = new TitledBorder(roundedLineBorder, sgTableTitle);

        commandPanel.setBorder(commandTitledBorder);
        argumentPanel.setBorder(argumentTitledBorder);
        client.setBorder(clientTitledBorder);
        server.setBorder(serverTitledBorder);
        sgScrollPane.setBorder(sgTableTitledBorder);
    }

    private void createUIComponents() {
        ComboBoxToolTipRenderer<String> renderer = new ComboBoxToolTipRenderer<>();
        commandBox = new JComboBox<>();
        commandBox.setRenderer(renderer);
    }
}