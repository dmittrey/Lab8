package gui.main;

import gui.*;
import utility.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainModel extends MainFrame {
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

    public MainModel(MainController mainController, FrameHandler aFrameHandler) {
        submitButton.addActionListener(e -> mainController.executeCommand());
        jTable.setModel(SGTableWorker.getInstance());

        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int rowAtPoint = jTable.rowAtPoint(e.getPoint());
                String sgId = (String) jTable.getValueAt(rowAtPoint, 0);
                System.out.println(sgId);
                new SGChangeMenu(aFrameHandler, sgId).show(e.getComponent(), e.getX(), e.getY());
            }
        });
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

    private void createUIComponents() {
        ComboBoxToolTipRenderer<String> renderer = new ComboBoxToolTipRenderer<>();
        commandBox = new JComboBox<>();
        commandBox.setRenderer(renderer);
    }
}