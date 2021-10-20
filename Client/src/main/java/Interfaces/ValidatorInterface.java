package Interfaces;

import utility.Command;
import utility.Session;

public interface ValidatorInterface {

    /**
     * Validate Commands without argument
     */
    boolean notObjectArgumentCommands(Command aCommand);

    /**
     * Validate Commands with object argument
     */
    boolean objectArgumentCommands(Command aCommand);

    /**
     * Validate Commands with script path argument
     */
    boolean scriptArgumentCommand(Command aCommand);

    /**
     * Validate Login and Register commands
     */
    boolean sessionCommands(Session aSession);

    boolean validateConnection(String remoteHostAddress, String remoteHostPort);
}
