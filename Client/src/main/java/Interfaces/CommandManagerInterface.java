package Interfaces;

import utility.Command;
import utility.Session;
import utility.TypeOfAnswer;

public interface CommandManagerInterface {

    /**
     * Validate and complete aCommand
     */
    void transferCommand(Command aCommand);

    TypeOfAnswer transferCommand(Session aSession);
}
