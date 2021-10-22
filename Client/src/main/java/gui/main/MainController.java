package gui.main;

import Interfaces.Relocatable;
import gui.*;
import utility.*;

import javax.swing.*;
import java.util.Locale;
import java.util.logging.Logger;

public class MainController implements Relocatable {

    private final MainModel model;
    private final MainModelAnimator mainModelAnimator;
    private static final Logger logger = Logger.getLogger(CommandManager.class.getName());

    public MainController(FrameHandler aFrameHandler) {
        model = new MainModel(this, aFrameHandler);
        mainModelAnimator = new MainModelAnimator(aFrameHandler, model.getClientInfo(), model.getServerInfo());
    }

    public MainModelAnimator getMainModelAnimator() {
        return mainModelAnimator;
    }

    public void setPanel(JFrame jFrame) {
        jFrame.setTitle("Study groups");
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

        CommandReader.getInstance().execute(command);
    }

    public void switchLanguage(Locale locale){

    }

    private void setUsername() {
        String username = RequestHandler.getInstance().getSession().getName();
        model.setUsername(username);
    }
}