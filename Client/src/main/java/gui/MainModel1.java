package gui;

import utility.*;

import javax.swing.*;
import java.util.logging.Logger;

public class MainModel1 extends JFrame {

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
    private JTextArea serverInfo;
    private JPanel server;
    private JScrollPane sgScrollPane;

    public MainModel1() {

        submitButton.addActionListener(e -> {
            TypeOfCommand command = TypeOfCommand.getEnum(commandBox.getItemAt(commandBox.getSelectedIndex()));
            String arg = argumentField.getText();
            logger.info("Обработка команды " + command);
            Response cmdResult = CommandReader.getInstance().execute(command, arg);
            if (command == TypeOfCommand.Show) createUIComponents();
            MainModelAnimator.getInstance().animate(cmdResult, clientInfo, serverInfo);
            logger.info(String.valueOf(SGTableWorker.getInstance().getRowCount()));
            sgScrollPane.repaint();
        });
    }


    public void setPanel(JFrame jFrame) {
        jFrame.setTitle("StudyGroups");
        jFrame.setContentPane(mainPanel);
        jFrame.setSize(1080, 720);
        jFrame.pack();
    }

    public void setClientInfo(String info) {
        clientInfo.setText(info);
    }

    public void setServerWarn(String info) {
        serverInfo.setText(info);
    }

    public void setUsername(String anUsername) {
        usernameField.setText(anUsername);
    }

    private void createUIComponents() {
        SGTableWorker sgTableWorker = SGTableWorker.getInstance();
        JTable jTable = new JTable(sgTableWorker);
        sgScrollPane = new JScrollPane(jTable);
    }
}
