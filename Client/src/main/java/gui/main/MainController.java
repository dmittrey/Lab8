package gui.main;

import gui.FrameHandler;
import gui.MainModelAnimator;
import gui.SGTableWorker;
import utility.*;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class MainController {

    private final MainModel model;
    private static final Logger logger = Logger.getLogger(CommandManager.class.getName());

    public MainController() {
        model = new MainModel(this);
    }

    public void setPanel(JFrame jFrame) {
        jFrame.setTitle("StudyGroups");
        setUsername();
        jFrame.setContentPane(model.getMainPanel());
        jFrame.setSize(1080, 560);
        setLocation(jFrame);
        jFrame.repaint();
    }

    public void executeCommand() {
        TypeOfCommand typeOfCommand = model.getTypeOfCommand();
        String arg = (model.getArgument().isEmpty()) ? null : model.getArgument();
        Command command = new Command(typeOfCommand, arg);

        logger.info("Обработка команды " + command);

        Response cmdResult = CommandReader.getInstance().execute(command);
        MainModelAnimator.getInstance().animate(cmdResult, model.getClientInfo(), model.getServerInfo());
        SGTableWorker.getInstance().fireTableDataChanged();
    }

    private void setUsername(){
        String username = RequestHandler.getInstance().getSession().getName();
        model.setUsername(username);
    }

    private void setLocation(JFrame jFrame) {
        int width = jFrame.getSize().width;
        int height = jFrame.getSize().height;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        jFrame.setLocation((screenSize.width / 2) - (width / 2), (screenSize.height / 2) - (height / 2));
    }
}