package Interfaces;

import utility.Command;
import utility.CommandManager;
import utility.Response;
import utility.Session;

public interface CommandReaderInterface {

    void setCommandManager(CommandManager aCommandManager);

    Response execute(Session session);

    Response execute(Command command);

    Command readCommand(String anInputString);
}
