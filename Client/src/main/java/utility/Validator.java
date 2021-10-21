package utility;

import Interfaces.ValidatorInterface;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Pattern;

/**
 * Class to validate commands
 */
public class Validator implements ValidatorInterface {

    private static AvailableCommands availableCommands;
    private static Validator instance;

    private Validator() {}

    public static Validator getInstance() {
        if (instance == null) {
            availableCommands = new AvailableCommands();
            instance = new Validator();
        }
        return instance;
    }

    @Override
    public boolean notObjectArgumentCommands(Command aCommand) {
        return validateNoArgumentCommand(aCommand) ||
                validateNumArgumentCommands(aCommand) ||
                validateStringArgumentCommands(aCommand);
    }

    @Override
    public boolean objectArgumentCommands(Command aCommand) {
        return validateObjectArgumentCommands(aCommand) ||
                validateObjAndNumArgumentCommand(aCommand);
    }

    @Override
    public boolean scriptArgumentCommand(Command aCommand) {
        return availableCommands.scriptArgumentCommand.equals(aCommand.getCommand()) &&
                aCommand.getArg() != null;
    }

    @Override
    public boolean scriptGUIArgumentCommand(Command aCommand){
        return availableCommands.scriptArgumentCommand.equals(aCommand.getCommand()) &&
                aCommand.getArg() == null;
    }

    @Override
    public boolean sessionCommands(Session aSession) {
        String username = aSession.getName();
        String password = aSession.getPassword();
        return validateLogin(username) && validatePassword(password);
    }

    @Override
    public boolean validateConnection(String remoteHostAddress, String remoteHostPort) {
        return validateHostAddress(remoteHostAddress) && validateHostPort(remoteHostPort);
    }

    private boolean validateHostAddress(String remoteHostAddress) {
        Pattern hostAddress = Pattern.compile("^\\s*([\\w.]+)\\s*");

        if (hostAddress.matcher(remoteHostAddress).find()) {
            try {
                InetAddress.getByName(remoteHostAddress);
                return true;
            } catch (UnknownHostException e) {
                return false;
            }
        } else return false;
    }

    private boolean validateHostPort(String port) {
        Pattern remoteHostPortPattern = Pattern.compile("^\\s*\\b(\\d{1,5})\\b\\s*");

        return remoteHostPortPattern.matcher(port).find() && (Integer.parseInt(port.trim()) < 65536
                || Integer.parseInt(port.trim()) > 0);
    }

    private boolean validateLogin(String username) {
        Pattern usernamePattern = Pattern.compile("^\\s*\\b(\\w+)\\b\\s*");
        return username != null && usernamePattern.matcher(username).find();
    }

    private boolean validatePassword(String password) {
        Pattern passwordPattern = Pattern.compile("^\\s*([\\d\\w]*)\\s*");
        return password == null || passwordPattern.matcher(password).find();
    }

    private boolean validateNoArgumentCommand(Command aCommand) {
        return availableCommands.noArgumentCommands.contains(aCommand.getCommand()) &&
                aCommand.getArg() == null;
    }

    private boolean validateNumArgumentCommands(Command aCommand) {
        return availableCommands.numArgumentCommands.contains(aCommand.getCommand()) &&
                aCommand.isArgInt() && Integer.parseInt(aCommand.getArg()) > 0;
    }

    private boolean validateStringArgumentCommands(Command aCommand) {
        return availableCommands.stringArgumentCommands.contains(aCommand.getCommand()) &&
                aCommand.getArg() != null;
    }

    private boolean validateObjectArgumentCommands(Command aCommand) {
        return availableCommands.objectArgumentCommands.contains(aCommand.getCommand()) &&
                aCommand.getArg() == null;
    }

    private boolean validateObjAndNumArgumentCommand(Command aCommand) {
        return (availableCommands.objAndNumArgumentCommand == aCommand.getCommand()) &&
                aCommand.isArgInt() && Integer.parseInt(aCommand.getArg()) > 0;
    }
}