package utility;

import Interfaces.*;

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

    private final CommandReaderInterface commandReader;
    private final ValidatorInterface validator;
    private final RequestHandlerInterface requestHandler;
    private final ConsoleInterface console;
    private final Set<String> usedScripts;
    private final StudyGroupFactoryInterface studyGroupFactory;

    public CommandManager() {

        commandReader = null;
        validator = Validator.getInstance();
        requestHandler = RequestHandler.getInstance();
        console = Console.getInstance();
        usedScripts = new HashSet<>();
        studyGroupFactory = new StudyGroupFactory();
    }

    @Override
    public Response transferCommand(Command aCommand) {

        return (aCommand == null)
                ? new Response(TypeOfAnswer.NOTVALIDATE)
                : requestHandler.send(aCommand);
    }

    @Override
    public Response transferCommand(Session aSession) {
        logger.info("In cmdManager");
        if (validator.sessionCommands(aSession)) {
            logger.info("Прошли валидацию");
            if ((aSession.getTypeOfSession() == TypeOfSession.Register)) {
                logger.info("register...");
                return requestHandler.register(aSession);
            } else {
                logger.info("logging...");
                return requestHandler.login(aSession);
            }
        }
        return new Response(TypeOfAnswer.NOTVALIDATE);
    }

    private void executeScript(String scriptName) {

        if (usedScripts.add(scriptName)) {

            try {
                if (usedScripts.size() == 1) console.setExeStatus(true);

                ScriptReader scriptReader = new ScriptReader(this, commandReader, new File(scriptName));
                try {
                    scriptReader.read();

                    System.out.println(TextFormatting.getGreenText("\nThe script " + scriptName
                            + " was processed successfully!\n"));
                } catch (IOException exception) {

                    usedScripts.remove(scriptName);

                    if (usedScripts.size() == 0) console.setExeStatus(false);

                    if (!new File(scriptName).exists()) console.print(
                            TextFormatting.getRedText("\n\tThe script does not exist!\n\n"));
                    else if (!new File(scriptName).canRead()) console.print(
                            TextFormatting.getRedText("\n\tThe system does not have permission to read the file!\n\n"));
                    else console.print("\n\tWe have some problem's with script!\n\n");
                }
                usedScripts.remove(scriptName);
                if (usedScripts.size() == 0) console.setExeStatus(false);
            } catch (FileNotFoundException e) {
                console.print("\n\tScript not found!\n");
            }
        } else console.print(TextFormatting.getRedText("\nRecursion has been detected! Script " + scriptName +
                " will not be ran!\n"));
    }
}