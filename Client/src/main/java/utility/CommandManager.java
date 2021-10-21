package utility;

import Interfaces.*;
import gui.FrameHandler;
import gui.MainModelAnimator;
import gui.addDetails.AddDetailsController;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

/**
 * The class that serves the command
 */
public class CommandManager implements CommandManagerInterface {

    private static final Logger logger = Logger.getLogger(CommandManager.class.getName());

    private final ValidatorInterface validator;
    private final RequestHandlerInterface requestHandler;
    private final ConsoleInterface console;
    private final Set<String> usedScripts;
    private final MainModelAnimator mainModelAnimator;

    public CommandManager(FrameHandler aFrameHandler) {
        mainModelAnimator = aFrameHandler.getMainModelAnimator();
        validator = Validator.getInstance();
        requestHandler = RequestHandler.getInstance();
        console = Console.getInstance();
        usedScripts = new HashSet<>();
    }

    @Override
    public void transferCommand(Command aCommand) {
        if (validator.notObjectArgumentCommands(aCommand)) {
            if ((aCommand.getCommand() == TypeOfCommand.Show)) {
                mainModelAnimator.animateShow(requestHandler.send(aCommand));
            } else {
                logger.info("Обрабатываем команду:" + aCommand);
                mainModelAnimator.animate(requestHandler.send(aCommand));
            }
        } else if (validator.objectArgumentCommands(aCommand)) {
            if (console.getExeStatus()) aCommand.addStudyGroup(new StudyGroupFactory().createScriptStudyGroup());
            else new AddDetailsController(aCommand).spawnModel();

            if (aCommand.getStudyGroup() != null) {
                mainModelAnimator.animate(requestHandler.send(aCommand));
            } else mainModelAnimator.animate(new Response(TypeOfAnswer.NOTVALIDATE));
        } else if (validator.scriptGUIArgumentCommand(aCommand)) {
            JFileChooser fileOpen = new JFileChooser();
            int ret = fileOpen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileOpen.getSelectedFile();
                executeScript(file);
            }
        } else if (validator.scriptArgumentCommand(aCommand)) {
            executeScript(new File(aCommand.getArg()));
        } else mainModelAnimator.animate(new Response(TypeOfAnswer.NOTVALIDATE));
    }

    @Override
    public Response transferCommand(Session aSession) {
        if (validator.sessionCommands(aSession)) {
            if ((aSession.getTypeOfSession() == TypeOfSession.Register)) {
                return requestHandler.register(aSession);
            } else {
                return requestHandler.login(aSession);
            }
        }
        return new Response(TypeOfAnswer.NOTVALIDATE);
    }

    private void executeScript(File script) {

        if (usedScripts.add(script.getAbsolutePath())) {
            try {
                if (usedScripts.size() == 1) console.setExeStatus(true);

                ScriptReader scriptReader = new ScriptReader(script);
                try {
                    scriptReader.read();

                    mainModelAnimator.animate(new Response(TypeOfAnswer.SUCCESSFUL));
                } catch (IOException exception) {
                    usedScripts.remove(script.getAbsolutePath());
                    if (usedScripts.size() == 0) console.setExeStatus(false);

                    if (script.exists())
                        mainModelAnimator.animate(new Response(TypeOfAnswer.PERMISSIONDENIED));
                    else
                        mainModelAnimator.animate(new Response(TypeOfAnswer.OBJECTNOTEXIST));
                }
                usedScripts.remove(script.getAbsolutePath());
                if (usedScripts.size() == 0) console.setExeStatus(false);
            } catch (FileNotFoundException e) {
                mainModelAnimator.animate(new Response(TypeOfAnswer.OBJECTNOTEXIST));
            }
        } else mainModelAnimator.animate(new Response(TypeOfAnswer.RECURSIONDETECTED));
    }
}