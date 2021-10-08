package utility;

/**
 * Class to pack the commands and give it to CommandManager
 */
public class CommandReader {

    private CommandManager commandManager;
    private CommandReader instance;

    public CommandReader getInstance() {
        if (instance == null) instance = new CommandReader();
        return instance;
    }

    private CommandReader() {
    }

    public void setCommandManager(CommandManager aCommandManager) {
        commandManager = aCommandManager;
    }

    public <T extends TypeOfCommand> void execute(T typeOfCommand, String anArg) {
        Command command = new Command(typeOfCommand, anArg);
        commandManager.transferCommand(command);
    }
}