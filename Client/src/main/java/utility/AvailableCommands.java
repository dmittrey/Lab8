package utility;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Class for storage available commands
 */
public class AvailableCommands {

    public final Set<TypeOfCommand> noArgumentCommands = new HashSet<>();
    public final Set<TypeOfCommand> numArgumentCommands = new HashSet<>();
    public final Set<TypeOfCommand> stringArgumentCommands = new HashSet<>();
    public final Set<TypeOfCommand> objectArgumentCommands = new HashSet<>();
    public final TypeOfCommand scriptArgumentCommand;
    public final TypeOfCommand objAndNumArgumentCommand;

    public AvailableCommands() {

        Collections.addAll(noArgumentCommands,
                TypeOfCommand.Help,
                TypeOfCommand.Info,
                TypeOfCommand.Show,
                TypeOfCommand.Clear,
                TypeOfCommand.History,
                TypeOfCommand.Min_by_students_count);

        Collections.addAll(numArgumentCommands,
                TypeOfCommand.Remove_by_id,
                TypeOfCommand.Count_less_than_students_count);

        Collections.addAll(stringArgumentCommands,
                TypeOfCommand.Filter_starts_with_name);

        Collections.addAll(objectArgumentCommands,
                TypeOfCommand.Add,
                TypeOfCommand.Add_if_max,
                TypeOfCommand.Add_if_min);

        scriptArgumentCommand = TypeOfCommand.Execute_script;

        objAndNumArgumentCommand = TypeOfCommand.Update;
    }
}