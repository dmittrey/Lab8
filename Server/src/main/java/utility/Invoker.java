package utility;

import commands.*;

import java.util.*;

/**
 * Invoker class from pattern Command to logging commands from client
 */
public class Invoker {

    private final Map<TypeOfCommand, CommandAbstract> commands;
    private final Receiver receiver;

    public Invoker(Receiver aReceiver) {
        commands = new HashMap<>();
        receiver = aReceiver;
        initMap();
    }

    public Receiver getReceiver() {
        return receiver;
    }

    public Response execute(Request aRequest) {
        TypeOfCommand aCommand = aRequest.getCommand().getCommand();
        String username = aRequest.getSession().getName();
        String password = aRequest.getSession().getPassword();
        return (!commands.get(aCommand).getAuthorizationStatus())
                ? commands.get(aCommand).execute(aRequest)
                : (aCommand == TypeOfCommand.Register || receiver.loginUser(username, password))
                    ? commands.get(aCommand).execute(aRequest)
                    : new Response(TypeOfAnswer.NOTMATCH);
    }

    private void initMap() {
        commands.put(TypeOfCommand.Help, new Help(commands, receiver));//Map<String, String>
        commands.put(TypeOfCommand.Info, new Info(receiver));//Map<String, String>
        commands.put(TypeOfCommand.Show, new Show(receiver));//Set<StudyGroup>
        commands.put(TypeOfCommand.Add, new Add(receiver));//TypeOfAnswer
        commands.put(TypeOfCommand.Update, new UpdateId(receiver));//TypeOfAnswer
        commands.put(TypeOfCommand.Remove_by_id, new RemoveById(receiver));//TypeOfAnswer
        commands.put(TypeOfCommand.Clear, new Clear(receiver));//TypeOfAnswer
        commands.put(TypeOfCommand.Add_if_max, new AddIfMax(receiver));//TypeOfAnswer
        commands.put(TypeOfCommand.Add_if_min, new AddIfMin(receiver));//TypeOfAnswer
        commands.put(TypeOfCommand.History, new History(receiver));//Map<String, String>
        commands.put(TypeOfCommand.Min_by_students_count, new MinByStudentsCount(receiver));//StudyGroup
        commands.put(TypeOfCommand.Count_less_than_students_count, new CountLessThanStudentsCount(receiver));//Long
        commands.put(TypeOfCommand.Filter_starts_with_name, new FilterStartsWithName(receiver));//Set<StudyGroup>
        commands.put(TypeOfCommand.Register, new RegisterUser(receiver));//TypeOfAnswer
        commands.put(TypeOfCommand.Login, new LoginUser(receiver));//TypeOfAnswer
    }
}