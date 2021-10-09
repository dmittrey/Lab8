package Interfaces;

import utility.Command;
import utility.Response;
import utility.Session;

public interface CommandManagerInterface {

    /**
     * Validate and complete aCommand
     * @return
     */
    Response transferCommand(Command aCommand);

    Response transferCommand(Session aSession);
}
