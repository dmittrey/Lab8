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
    private final SGChangeMenu sgChangeMenu;

    public MainModel(MainController mainController, SGChangeMenu aSGChangeMenu) {
        submitButton.addActionListener(e -> mainController.executeCommand());
        sgChangeMenu = aSGChangeMenu;
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
        SGTableWorker sgTableWorker = SGTableWorker.getInstance();
        JTable jTable = new JTable(sgTableWorker);
        jTable.setModel(SGTableWorker.getInstance());
        sgScrollPane = new JScrollPane(jTable);
        jTable.setAutoCreateRowSorter(true);

        ComboBoxToolTipRenderer<String> renderer = new ComboBoxToolTipRenderer<>();
        commandBox = new JComboBox<>();
        commandBox.setRenderer(renderer);

        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                jTable.setComponentPopupMenu(sgChangeMenu);
            }
        });
    }
}