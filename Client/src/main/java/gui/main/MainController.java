package gui.main;

import Interfaces.Localizable;
import Interfaces.Relocatable;
import gui.*;
import utility.*;

import javax.swing.*;
import java.util.Locale;
import java.util.logging.Logger;

public class MainController implements Relocatable, Localizable {

    private final MainModel model;
    private final MainModelAnimator mainModelAnimator;
    private final FrameHandler frameHandler;
    private static final Logger logger = Logger.getLogger(CommandManager.class.getName());

    public MainController(FrameHandler aFrameHandler) {
        frameHandler = aFrameHandler;
        model = new MainModel(this, frameHandler);
        mainModelAnimator = new MainModelAnimator(frameHandler, model.getClientInfo(), model.getServerInfo());
    }

    public MainModelAnimator getMainModelAnimator() {
        return mainModelAnimator;
    }

    public void setPanel(JFrame jFrame) {
        jFrame.setTitle("Study groups table");
        setUsername();
        jFrame.setContentPane(model.getMainPanel());
        jFrame.setSize(1080, 560);
        setLocation(jFrame);
        jFrame.revalidate();
    }

    public void executeCommand() {
        TypeOfCommand typeOfCommand = model.getTypeOfCommand();
        String arg = (model.getArgument().isEmpty()) ? null : model.getArgument();
        Command command = new Command(typeOfCommand, arg);

        logger.info("Обработка команды " + command);

        CommandReader.getInstance().execute(command);
    }

    public void switchLanguage(Locale locale) {
        model.switchLanguage(locale);
    }

    public void notifySwitchLanguage(Locale locale) {
        frameHandler.switchLanguage(locale);
    }

    private void setUsername() {
        String username = RequestHandler.getInstance().getSession().getName();
        model.setUsername(username);
    }
}