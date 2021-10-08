package commands;

import utility.*;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class for displaying all commands with explanations
 */
public class Help extends CommandAbstract {

    private final Map<TypeOfCommand, CommandAbstract> commands;
    private final Receiver receiver;

    public Help(Map<TypeOfCommand, CommandAbstract> aCommands, Receiver aReceiver) {
        super("display help for available commands", false);
        commands = aCommands;
        receiver = aReceiver;
    }

    @Override
    public Response execute(Request aRequest) {
        String username = aRequest.getSession().getName();

        Map<String, String> mapOfCommands = commands.keySet()
                .stream()
                .filter(cmd -> !(cmd == TypeOfCommand.Register || cmd == TypeOfCommand.Login))
                .collect(Collectors.toConcurrentMap(Enum::toString, command -> commands.get(command).getDescription()));
        mapOfCommands.put("execute_script", "Read and execute script from entered file");
        mapOfCommands.put("exit", "end the program");
        receiver.addToHistory(username, "help");
        return new Response(mapOfCommands, TypeOfAnswer.SUCCESSFUL);
    }
}