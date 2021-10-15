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
            TypeOfCommand typeOfCommand = TypeOfCommand.getEnum(commandBox.getItemAt(commandBox.getSelectedIndex()));
            String arg = argumentField.getText();
            Command command = new Command(typeOfCommand, arg);

            logger.info("Обработка команды " + command);

            if (typeOfCommand == TypeOfCommand.Add
                    || typeOfCommand == TypeOfCommand.Add_if_max
                    || typeOfCommand == TypeOfCommand.Add_if_min
                    || typeOfCommand == TypeOfCommand.Update) {
                FrameHandler.getInstance().spawnFieldsChanger(command);
            }

            Response cmdResult = CommandReader.getInstance().execute(command);
            MainModelAnimator.getInstance().animate(cmdResult, clientInfo, serverInfo);
            cmdResult = CommandReader.getInstance().execute(new Command(TypeOfCommand.Show, ""));
            MainModelAnimator.getInstance().animate(cmdResult, clientInfo, serverInfo);
            SGTableWorker.getInstance().fireTableDataChanged();
        });
    }

    public void setPanel(MainFrame jFrame) {
        jFrame.setTitle("StudyGroups");
        usernameField.setText(RequestHandler.getInstance().getSession().getName());
        jFrame.setContentPane(mainPanel);
        jFrame.setSize(1080, 560);
        jFrame.setLocation();
        jFrame.repaint();
    }

    private void createUIComponents() {
        SGTableWorker sgTableWorker = SGTableWorker.getInstance();
        JTable jTable = new JTable(sgTableWorker);
        jTable.setModel(SGTableWorker.getInstance());
        sgScrollPane = new JScrollPane(jTable);

        ComboBoxToolTipRenderer<String> renderer = new ComboBoxToolTipRenderer<>();
        commandBox = new JComboBox<>();
        commandBox.setRenderer(renderer);
    }
}