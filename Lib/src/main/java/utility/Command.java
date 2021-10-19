package utility;

import data.StudyGroup;

import java.io.Serializable;

/**
 * Class to serialize commands
 */
public class Command implements Serializable {

    private final TypeOfCommand commandName;
    private final String argName;
    private StudyGroup studyGroup;

    public Command(TypeOfCommand aCommandName, String anArgName) {

        commandName = aCommandName;
        argName = anArgName;
        studyGroup = null;
    }

    public Command addStudyGroup(StudyGroup aStudyGroup) {
        if (aStudyGroup != null) studyGroup = aStudyGroup;
        return this;
    }

    public TypeOfCommand getCommand() {
        return commandName;
    }

    public String getArg() {
        return argName;
    }

    public StudyGroup getStudyGroup() {
        return studyGroup;
    }

    @Override
    public String toString() {
        return commandName + " "
                + (argName != null ? argName + "\n" : "\n")
                + (studyGroup != null ? studyGroup : "");
    }

    public boolean isArgInt() {
        try {
            if (argName != null) {
                Integer.parseInt(argName);
                return true;
            } else return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}