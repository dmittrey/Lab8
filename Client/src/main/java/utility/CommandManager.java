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
    private final FrameHandler frameHandler;
    private final MainModelAnimator mainModelAnimator;

    public CommandManager(FrameHandler aFrameHandler) {
        frameHandler = aFrameHandler;
        mainModelAnimator = frameHandler.getMainModelAnimator();
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
        }
        else if (validator.objectArgumentCommands(aCommand)) {
            new AddDetailsController(aCommand).spawnModel();
            if (aCommand.getStudyGroup() != null) {
                mainModelAnimator.animate(requestHandler.send(aCommand));
            } else mainModelAnimator.animate(new Response(TypeOfAnswer.NOTVALIDATE));

        } else if (validator.scriptArgumentCommand(aCommand)) {
            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();
                executeScript(file);
            }
            mainModelAnimator.animate(new Response(TypeOfAnswer.SUCCESSFUL));
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

                    System.out.println(TextFormatting.getGreenText("\nThe script " + script.getName()
                            + " was processed successfully!\n"));
                } catch (IOException exception) {

                    usedScripts.remove(script.getAbsolutePath());

                    if (usedScripts.size() == 0) console.setExeStatus(false);

                    if (!script.exists()) console.print(
                            TextFormatting.getRedText("\n\tThe script does not exist!\n\n"));
                    else if (!script.canRead()) console.print(
                            TextFormatting.getRedText("\n\tThe system does not have permission to read the file!\n\n"));
                    else console.print("\n\tWe have some problem's with script!\n\n");
                }
                usedScripts.remove(script.getAbsolutePath());
                if (usedScripts.size() == 0) console.setExeStatus(false);
            } catch (FileNotFoundException e) {
                console.print("\n\tScript not found!\n");
            }
        } else console.print(TextFormatting.getRedText("\nRecursion has been detected! Script " + script.getName() +
                " will not be ran!\n"));
    }
}