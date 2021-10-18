package gui.main;

import gui.*;
import gui.actions.RemoveAction;
import gui.actions.UpdateAction;
import utility.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

public class MainModel extends JFrame {

    private static final Logger logger = Logger.getLogger(CommandManager.class.getName());

    private final RemoveAction removeAction;
    private final UpdateAction updateAction;
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

    public MainModel(RemoveAction aRemoveAction, UpdateAction anUpdateAction) {

        removeAction = aRemoveAction;
        updateAction = anUpdateAction;

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
        jTable.setAutoCreateRowSorter(true);

        ComboBoxToolTipRenderer<String> renderer = new ComboBoxToolTipRenderer<>();
        commandBox = new JComboBox<>();
        commandBox.setRenderer(renderer);

        jTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SGChangeMenu sgChangeMenu = new SGChangeMenu(removeAction, updateAction);
                jTable.setComponentPopupMenu(sgChangeMenu);
            }
        });
    }
}