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
    private JTable sgTable;

    public MainModel1() {

        JTable jTable = new JTable(SGTableWorker.getInstance());
        sgScrollPane.setViewportView(jTable);
        String[] str = new String[13];
        str[0] = "Hi";
        str[1] = "Hi";
        str[2] = "Hi";
        str[3] = "Hi";
        str[4] = "Hi";
        str[5] = "Hi";
        str[6] = "Hi";
        str[7] = "Hi";
        str[8] = "Hi";
        str[9] = "Hi";
        str[10] = "Hi";
        str[11] = "Hi";
        str[12] = "Hi";
        SGTableWorker.getInstance().addData(str);

        submitButton.addActionListener(e -> {
            TypeOfCommand command = TypeOfCommand.getEnum(commandBox.getItemAt(commandBox.getSelectedIndex()));
            String arg = argumentField.getText();
            logger.info("Обработка команды " + command);
            Response cmdResult = CommandReader.getInstance().execute(command, arg);
            MainModelAnimator.getInstance().animate(cmdResult, clientInfo, serverInfo);
            logger.info(String.valueOf(SGTableWorker.getInstance().getRowCount()));
            pack();
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
}
