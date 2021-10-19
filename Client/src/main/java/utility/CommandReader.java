package utility;

/**
 * Class to pack the commands and give it to CommandManager
 */
public class CommandReader {

    private CommandManager commandManager;
    private static CommandReader instance;

    public static CommandReader getInstance() {
        if (instance == null) instance = new CommandReader();
        return instance;
    }

    private CommandReader() {
    }

    public void setCommandManager(CommandManager aCommandManager) {
        commandManager = aCommandManager;
    }

    /**
     * Method to register/auth user
     */
    public Response execute(Session session) {
        return commandManager.transferCommand(session);
    }

    /**
     * Method to execute command
     */
    public Response execute(Command command) {
        return commandManager.transferCommand(command);
    }
}