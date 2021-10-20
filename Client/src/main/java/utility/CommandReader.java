package utility;

import Interfaces.CommandReaderInterface;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class to pack the commands and give it to CommandManager
 */
public class CommandReader implements CommandReaderInterface {

    private CommandManager commandManager;
    private static CommandReader instance;

    public static CommandReader getInstance() {
        if (instance == null) instance = new CommandReader();
        return instance;
    }

    private CommandReader() {
    }

    @Override
    public void setCommandManager(CommandManager aCommandManager) {
        commandManager = aCommandManager;
    }

    /**
     * Method to register/auth user
     */
    @Override
    public Response execute(Session session) {
        return commandManager.transferCommand(session);
    }

    /**
     * Method to execute command
     */
    @Override
    public void execute(Command command) {
        commandManager.transferCommand(command);
    }

    @Override
    public Command readCommand(String anInputString) {

        if (anInputString == null) return null;

        String command;
        String arg;
        Pattern commandName = Pattern.compile("^\\w+\\s+");
        Pattern argName = Pattern.compile("^.+");
        Matcher matcher = commandName.matcher(anInputString + " ");

        if (matcher.find()) {
            command = matcher.group().trim();
        } else {
            return null;
        }

        matcher = argName.matcher(anInputString.substring(command.length()));

        if (matcher.find()) {
            arg = matcher.group().trim();
            if (arg.equals("")) arg = null;
        } else arg = null;

        return new Command(TypeOfCommand.getEnum(command), arg);
    }
}