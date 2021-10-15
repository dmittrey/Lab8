package gui;

import utility.*;

import javax.swing.*;
import java.util.logging.Logger;

public class MainModel extends JFrame {

    private static final Logger logger = Logger.getLogger(CommandManager.class.getName());

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

    public MainModel() {

        submitButton.addActionListener(e -> {
            TypeOfCommand command = TypeOfCommand.getEnum(commandBox.getItemAt(commandBox.getSelectedIndex()));
            String arg = argumentField.getText();
            logger.info("Обработка команды " + command);

            Response cmdResult = CommandReader.getInstance().execute(command, arg);
            MainModelAnimator.getInstance().animate(cmdResult, clientInfo, serverInfo);
            SGTableWorker.getInstance().fireTableDataChanged();
        });
    }

    public void setPanel(MainFrame jFrame) {
        jFrame.setTitle("StudyGroups");
        jFrame.setContentPane(mainPanel);
        jFrame.setSize(1080, 560);
        jFrame.setLocation();
        jFrame.repaint();
    }
//
//    public void setClientInfo(String info) {
//        clientInfo.setText(info);
//    }
//
//    public void setServerWarn(String info) {
//        serverInfo.setText(info);
//    }
//
//    public void setUsername(String anUsername) {
//        usernameField.setText(anUsername);
//    }

    private void createUIComponents() {
        SGTableWorker sgTableWorker = SGTableWorker.getInstance();
        JTable jTable = new JTable(sgTableWorker);
        jTable.setModel(SGTableWorker.getInstance());
        sgScrollPane = new JScrollPane(jTable);
    }
}
