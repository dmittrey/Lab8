package utility;

public enum TypeOfCommand {
    Help("Help"),
    Info("Info"),
    Show("Show"),
    Clear("Clear"),
    History("History"),
    Min_by_students_count("Min_by_students"),
    Remove_by_id("Remove_by_id"),
    Count_less_than_students_count("Count_less_than_students_count"),
    Filter_starts_with_name("Filter_starts_with_name"),
    Add("Add"),
    Add_if_max("Add_if_max"),
    Add_if_min("Add_if_min"),
    Execute_script("Execute_script"),
    Update("Update"),
    Register("Register"),
    Login("Login"),
    Exit("Exit");

    private final String value;

    TypeOfCommand(String aValue) {
        value = aValue;
    }

    public String getValue() {
        return value;
    }

    public static TypeOfCommand getEnum(String value) {
        if (value != null) {
            for (TypeOfCommand v : values())
                if (v.getValue().equalsIgnoreCase(value)) return v;
        }
        return null;
    }
}
